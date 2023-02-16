package net.konohana.sakuya.hiiragi.domain.service

import net.konohana.sakuya.hiiragi.domain.repository.HiiragiRW02Repository

object HiiragiRW02Service {
    fun create(
        routeID: String,
        staCode: String,
        staName: String,
    ) = HiiragiRW02Repository.create(
        routeID,
        staCode,
        staName
    )
    fun findByStaCode(staCode: String) = HiiragiRW02Repository.findByStaCode(staCode)
}
