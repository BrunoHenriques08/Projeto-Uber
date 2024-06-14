package com.brunohenriques.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {

        get("/") {
            call.respondFile(File("paginas/index.html"))
        }

        post("/formulario") {
            val parametros: Parameters = call.receiveParameters()
            val username = parametros["username"] ?: return@post call.respond(HttpStatusCode.BadRequest, "Faltou o username")
            val password = parametros["password"] ?: return@post call.respond(HttpStatusCode.BadRequest, "Faltou o password")

            val loginRequest = LoginRequest(username, password)
            if (validateLogin(loginRequest)) {
                println("Login bem-sucedido para usuário: $username")
                when (username) {
                    "client" -> call.respondRedirect("/client")
                    "driver" -> call.respondRedirect("/driver")
                    else -> call.respondText("Utilizador não tem permissões para aceder.")
                }
            } else {
                println("Credenciais inválidas para usuário: $username")
                call.respond(HttpStatusCode.Unauthorized, "Credenciais inválidas")
            }
        }

        get("/client") {
            call.respondFile(File("paginas/client.html"))
        }

        post("/client") {
            val parametros: Parameters = call.receiveParameters()
            val latpartida = parametros["latpartida"]
            val longpartida = parametros["longpartida"]
            val latdestino = parametros["latdestino"]
            val longdestino = parametros["longdestino"]

            // Verificação básica de presença de parâmetros
            if (latpartida.isNullOrBlank() || longpartida.isNullOrBlank() || latdestino.isNullOrBlank() || longdestino.isNullOrBlank()) {
                return@post call.respond(HttpStatusCode.BadRequest, "Faltam parâmetros obrigatórios")
            }

            val coordenadasJson = """{"Where i am": [$latpartida, $longpartida], "heading to": [$latdestino, $longdestino]}"""
            println("Latpartida: $latpartida Longpartida: $longpartida Latdestino: $latdestino Longdestino: $longdestino")

            call.respondText(coordenadasJson, contentType = ContentType.Application.Json)
        }

        get("/driver") {
            call.respondFile(File("paginas/driver.html"))
        }

        get("/map") {
            call.respondFile(File("paginas/leaflet.html"))
        }

        // Exemplo de rota para gerar conteúdo dinâmico em uma div
        get("/conteudo-div") {
            val conteudoDiv = "Novo conteúdo dinâmico gerado pelo Ktor."
            call.respondText(conteudoDiv, contentType = ContentType.Text.Html)
        }
    }
}

data class LoginRequest(val username: String, val password: String)

fun validateLogin(request: LoginRequest): Boolean {
    return (request.username == "driver" && request.password == "123456") ||
            (request.username == "client" && request.password == "123456")
}
