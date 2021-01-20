package com.hvn.usuario.data.room

import android.os.Build.ID
import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object UsuarioDbContract {

    object UsuarioEntry : BaseColumns {
        const val TABLE_NAME = "Usuario"
        const val COLUMN_NAME = "name"
        const val COLUMN_LOCATION = "localization"
        const val COLUMN_URL = "url"

        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TABLE_NAME (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME TEXT NOT NULL," +
                    "$COLUMN_LOCATION TEXT NULL," +
                    "$COLUMN_URL TEXT NOT NULL)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

}