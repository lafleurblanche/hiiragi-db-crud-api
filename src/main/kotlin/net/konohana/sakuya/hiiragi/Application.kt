package net.konohana.sakuya.hiiragi

import io.ktor.server.application.Application
import net.konohana.sakuya.hiiragi.db.initHiiragiDB
import net.konohana.sakuya.hiiragi.plugins.configureHTTP
import net.konohana.sakuya.hiiragi.plugins.configureRouting
import net.konohana.sakuya.hiiragi.plugins.configureSerialization

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val url = environment.config.property("ktor.hiiragidb.uri").getString()
    val username = environment.config.property("ktor.hiiragidb.username").getString()
    val password = environment.config.property("ktor.hiiragidb.password").getString()
    initHiiragiDB(url, username, password)
    configureSerialization()
    configureHTTP()
    configureRouting()
}
