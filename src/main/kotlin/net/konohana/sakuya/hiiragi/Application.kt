package net.konohana.sakuya.hiiragi

import io.ktor.server.application.Application
import net.konohana.sakuya.hiiragi.plugins.configureHTTP
import net.konohana.sakuya.hiiragi.plugins.configureRouting
import net.konohana.sakuya.hiiragi.plugins.configureSerialization

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureHTTP()
    configureRouting()
}
