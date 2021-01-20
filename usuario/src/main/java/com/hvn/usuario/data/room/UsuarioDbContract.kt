package com.hvn.usuario.data.room

import android.provider.BaseColumns

object UsuarioDbContract {

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${UsuarioEntry.TABLE_NAME} (" +
                "${UsuarioEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTO INCREMENT," +
                "${UsuarioEntry.COLUMN_NAME} TEXT NOT NULL" +
                "${UsuarioEntry.COLUMN_LOCATION} TEXT NULL" +
                "${UsuarioEntry.COLUMN_URL} TEXT NOT NULL)"

    const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS ${UsuarioEntry.TABLE_NAME}"

    object UsuarioEntry : BaseColumns {
        const val TABLE_NAME = "Usuario"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_LOCATION = "localization"
        const val COLUMN_URL = "url"
    }
}