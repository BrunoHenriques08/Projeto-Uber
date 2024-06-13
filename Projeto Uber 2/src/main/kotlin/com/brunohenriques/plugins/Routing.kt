package com.brunohenriques.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {

        get("/") {
            call.respondFile(File("paginas/index.html"))
        }

        post("/") {
            val parametros:Parameters = call.receiveParameters()
            val nome = parametros["nome"]
            val email = parametros["email"]
            //...
            call.respondText { "Submissão feita com sucesso! " +
                    "${nome} ${email}" }
        }
    }
}


data class LoginRequest(val username: String, val password: String)

fun validateLogin(request: LoginRequest): Boolean {

    return (request.username == "admin" && request.password == "123456") ||
            (request.username == "client" && request.password == "654321")
}