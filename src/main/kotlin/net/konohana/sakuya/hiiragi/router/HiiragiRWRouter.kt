package net.konohana.sakuya.hiiragi.router

import io.ktor.server.routing.Route
import net.konohana.sakuya.hiiragi.controller.hiiragiRW01Controller

fun Route.hiiragiRWRouter() {
    hiiragiRW01Controller()
}
