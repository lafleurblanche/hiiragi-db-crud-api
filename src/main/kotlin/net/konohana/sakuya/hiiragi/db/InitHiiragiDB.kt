package net.konohana.sakuya.hiiragi.db

import org.jetbrains.exposed.sql.Database

fun initHiiragiDB(url: String, username: String, password: String) = Database.connect(
    // DBに接続する情報を記載する。
    url = url,
    driver = "org.postgresql.Driver",
    user = username,
    password = password
)
