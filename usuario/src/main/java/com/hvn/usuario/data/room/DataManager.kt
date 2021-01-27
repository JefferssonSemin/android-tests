package com.hvn.usuario.data.room

import android.content.ContentValues
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

            usuarios.add(Usuario(id, name, location, url, ""))
        }

        cursor.close()

        return usuarios
    }

    fun buscaUsuarioPorId(databaseHelper: DatabaseHelper, usuarioId: String): Usuario? {

        var usuario: Usuario? = null

        val db = databaseHelper.readableDatabase

        val columns = arrayOf(
            UsuarioEntry.COLUMN_ID,
            UsuarioEntry.COLUMN_NAME,
            UsuarioEntry.COLUMN_LOCATION,
            UsuarioEntry.COLUMN_URL
        )

        val selection = UsuarioEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs = arrayOf(usuarioId)

        val cursor = db.query(
            UsuarioEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        val idPos = cursor.getColumnIndex(UsuarioEntry.COLUMN_ID)
        val namePos = cursor.getColumnIndex(UsuarioEntry.COLUMN_NAME)
        val locationPos = cursor.getColumnIndex(UsuarioEntry.COLUMN_LOCATION)
        val urlPos = cursor.getColumnIndex(UsuarioEntry.COLUMN_URL)
        val urlImage = cursor.getColumnIndex(UsuarioEntry.COLUMN_URL_IMAGE)

        while (cursor.moveToNext()) {
            val id = cursor.getLong(idPos)
            val name = cursor.getString(namePos)
            val location = cursor.getString(locationPos)
            val url = cursor.getString(urlPos)
            val url_image = cursor.getString(urlImage)


            usuario = Usuario(id, name, location, url, url_image)
        }

        cursor.close()

        return usuario
    }

    fun atualizaUsuario(databaseHelper: DatabaseHelper, usuario: Usuario) {

        val db = databaseHelper.writableDatabase

        val values = ContentValues()
        with(values) {
            put(UsuarioEntry.COLUMN_NAME, usuario.name)
            put(UsuarioEntry.COLUMN_LOCATION, usuario.localization)
            put(UsuarioEntry.COLUMN_URL, usuario.url)
        }

        val selection = UsuarioEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs = arrayOf(usuario.id.toString())

        db.update(UsuarioEntry.TABLE_NAME, values, selection, selectionArgs)
    }

    fun deletaUsuario(databaseHelper: DatabaseHelper, userId: String): Int {

        val db = databaseHelper.writableDatabase


        val selection = UsuarioEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs = arrayOf(userId)

        return db.delete(UsuarioEntry.TABLE_NAME, selection, selectionArgs)
    }

}