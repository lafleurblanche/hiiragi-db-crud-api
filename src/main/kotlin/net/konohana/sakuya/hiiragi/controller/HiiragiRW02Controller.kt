package net.konohana.sakuya.hiiragi.controller

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import net.konohana.sakuya.hiiragi.domain.service.HiiragiRW02Service

fun Route.hiiragiRW02Controller() {
    route("hiiragi") {
        route("rw02") {
            post {
                val request = call.receive<HiiragiRW02Request>()
                val id = HiiragiRW02Service.create(
                    request.routeId,
                    request.staCode,
                    request.staName
                )
                call.respond(mapOf("id" to id))
            }
            get("{staCode}") {
                val staCode = call.parameters["staCode"]?.toString() ?: run {
                    return@get call.respond(HttpStatusCode.BadRequest, "駅名コードが指定されていません")
                }
                val hiiragiRW02Data = HiiragiRW02Service.findByStaCode(staCode) ?: run {
                    return@get call.respond(HttpStatusCode.NotFound, "データが存在しません staCode: $staCode")
                }
                call.respond(hiiragiRW02Data)
            }
        }
    }
}

data class HiiragiRW02Request(
    val routeId: String,
    val staCode: String,
    val staName: String,
)
