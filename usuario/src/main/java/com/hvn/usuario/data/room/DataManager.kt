package com.hvn.usuario.data.room

import com.hvn.usuario.domain.entities.Usuario
import com.hvn.usuario.data.room.UsuarioDbContract.UsuarioEntry

object DataManager {

    fun buscaTodosUsuarios(databaseHelper: DatabaseHelper): ArrayList<Usuario> {

        val usuarios = ArrayList<Usuario>()

        val db = databaseHelper.readableDatabase

        val columns = arrayOf(
            UsuarioEntry.COLUMN_ID,
            UsuarioEntry.COLUMN_NAME,
            UsuarioEntry.COLUMN_LOCATION,
            UsuarioEntry.COLUMN_URL
        )

        val cursor = db.query(
            UsuarioEntry.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        val idPos = cursor.getColumnIndex(UsuarioEntry.COLUMN_ID)
        val namePos = cursor.getColumnIndex(UsuarioEntry.COLUMN_NAME)
        val locationPos = cursor.getColumnIndex(UsuarioEntry.COLUMN_LOCATION)
        val urlPos = cursor.getColumnIndex(UsuarioEntry.COLUMN_URL)

        while (cursor.moveToNext()) {
            val id = cursor.getLong(idPos)
            val name = cursor.getString(namePos)
            val location = cursor.getString(locationPos)
            val url = cursor.getString(urlPos)

            usuarios.add(Usuario(id, name, location, url))
        }

        cursor.close()

        return usuarios
    }
}