package net.konohana.sakuya.hiiragi.domain.repository

import net.konohana.sakuya.hiiragi.domain.dto.HiiragiRW02Dto
import net.konohana.sakuya.hiiragi.domain.model.HiiragiRW02
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object HiiragiRW02Repository {
    fun create(
        routeID: String,
        staCode: String,
        staName: String,
    ) {
        transaction {
            HiiragiRW02.insertAndGetId {
                it[this.routeID] = routeID
                it[this.staCode] = staCode
                it[this.staName] = staName
            }.value
        }
    }

    fun findByStaCode(staCode: String) = transaction {
        HiiragiRW02.select { HiiragiRW02.staCode eq staCode }.singleOrNull()?.let {
            HiiragiRW02Dto(
                it[HiiragiRW02.id].value,
                it[HiiragiRW02.routeID],
                it[HiiragiRW02.staCode],
                it[HiiragiRW02.staName],
            )
        }
    }
}
