package com.hvn.usuario.data.room

import android.os.Build.ID
import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object UsuarioDbContract {

    object UsuarioEntry : BaseColumns {
        const val TABLE_NAME = "Usuario"
        const val COLUMN_ID = _ID
        const val COLUMN_NAME = "name"
        const val COLUMN_LOCATION = "localization"
        const val COLUMN_URL = "url"
        const val COLUMN_URL_IMAGE = "image"


        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TABLE_NAME (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME TEXT NOT NULL," +
                    "$COLUMN_LOCATION TEXT NULL," +
                    "$COLUMN_URL TEXT NOT NULL)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

        const val ALTER_TABLE_1 = "ALTER TABLE " +
                "$TABLE_NAME " +
                "ADD COLUMN " +
                "$COLUMN_URL_IMAGE TEXT NULL"
    }

}