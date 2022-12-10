package net.konohana.sakuya.hiiragi.domain.service

import net.konohana.sakuya.hiiragi.domain.repository.HiiragiRW01Repository

object HiiragiRW01Service {
    fun create(
        routeID: String,
        staCode: String,
        staName: String,
    ) = HiiragiRW01Repository.create(
        routeID,
        staCode,
        staName
    )
    fun findByStaCode(staCode: String) = HiiragiRW01Repository.findByStaCode(staCode)
}
