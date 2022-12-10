package net.konohana.sakuya.hiiragi.controller

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import net.konohana.sakuya.hiiragi.domain.service.HiiragiRW01Service

fun Route.hiiragiRW01Controller() {
    route("hiiragi") {
        route("rw01") {
            post {
                val request = call.receive<HiiragiRW01Request>()
                val id = HiiragiRW01Service.create(
                    request.routeId,
                    request.staCode,
                    request.staCode
                )
                call.respond(mapOf("id" to id))
            }
            get("{staCode}") {
                val staCode = call.parameters["staCode"]?.toString() ?: run {
                    return@get call.respond(HttpStatusCode.BadRequest, "駅名コードが指定されていません")
                }
                val hiiragiRW01Data = HiiragiRW01Service.findByStaCode(staCode) ?: run {
                    return@get call.respond(HttpStatusCode.NotFound, "データが存在しません staCode: $staCode")
                }
                call.respond(hiiragiRW01Data)
            }
        }
    }
}

data class HiiragiRW01Request(
    val routeId: String,
    val staCode: String,
    val staName: String,
)
