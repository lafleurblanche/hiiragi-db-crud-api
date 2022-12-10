package net.konohana.sakuya.hiiragi.domain.model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object HiiragiRW01 : IntIdTable("hiiragi_rw01") {
    val routeID: Column<String> = varchar("route_id", length = 20)
    val staCode: Column<String> = varchar("sta_code", length = 20)
    val staName: Column<String> = varchar("sta_name", length = 20)
}
