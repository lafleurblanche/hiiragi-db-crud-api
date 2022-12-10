package net.konohana.sakuya.hiiragi.domain.repository

import net.konohana.sakuya.hiiragi.domain.dto.HiiragiRW01Dto
import net.konohana.sakuya.hiiragi.domain.model.HiiragiRW01
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object HiiragiRW01Repository {
    fun create(
        routeID: String,
        staCode: String,
        staName: String,
    ) {
        transaction {
            HiiragiRW01.insertAndGetId {
                it[this.routeID] = routeID
                it[this.staCode] = staCode
                it[this.staName] = staName
            }.value
        }
    }

    fun findByStaCode(staCode: String) = transaction {
        HiiragiRW01.select { HiiragiRW01.staCode eq staCode }.singleOrNull()?.let {
            HiiragiRW01Dto(
                it[HiiragiRW01.id].value,
                it[HiiragiRW01.routeID],
                it[HiiragiRW01.staCode],
                it[HiiragiRW01.staName],
            )
        }
    }
}
