package com.hvn.usuario.data.room

import android.provider.BaseColumns

object UsuarioDbContract : BaseColumns {
    const val TABLE_NAME = "Usuario"
    const val COLUMN_ID = "id"
    const val COLUMN_NAME = "name"
    const val COLUMN_LOCATION = "localizacao"
    const val COLUMN_URL = "url"
}