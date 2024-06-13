val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project


plugins {
    kotlin("jvm") version "1.9.24"
    application
}

group = "com.brunohenriques"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.0.3")
    implementation("io.ktor:ktor-server-netty-jvm:2.0.3")
    implementation("io.ktor:ktor-server-host-common-jvm:2.0.3")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.0.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.0.3")
    implementation("ch.qos.logback:logback-classic:1.2.10")
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-tests-jvm:2.0.3")
    implementation("io.ktor:ktor-client-core:2.0.3")
    implementation("io.ktor:ktor-client-cio:2.0.3")
    implementation("io.ktor:ktor-server-call-logging:2.0.3")
    implementation("io.ktor:ktor-server-default-headers:2.0.3")
    implementation("io.ktor:ktor-server-default-headers:2.0.3")
    implementation("io.ktor:ktor-server-html-builder:2.0.3")
}

application {
    mainClass.set("com.brunohenriques.ApplicationKt")
}


tasks.test {
    useJUnitPlatform()
}
