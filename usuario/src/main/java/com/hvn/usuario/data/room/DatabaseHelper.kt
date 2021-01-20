package com.hvn.usuario.data.room

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(UsuarioDbContract.UsuarioEntry.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(UsuarioDbContract.UsuarioEntry.SQL_DROP_TABLE)
        onCreate(db)
    }

    // Realiza o downgrade da versão do banco
    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    // Logo após o downgrade, é chamado o open para novas execuções
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    companion object {
        const val DATABASE_NAME = "usuario.db"
        const val DATABASE_VERSION = 1
    }
}