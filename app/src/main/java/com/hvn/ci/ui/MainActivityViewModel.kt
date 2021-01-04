package com.hvn.ci.ui

import android.app.Application
import android.opengl.ETC1.isValid
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import java.lang.Exception

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val valueEdit: ObservableField<String> = ObservableField()
    private val resultado: ObservableField<String> = ObservableField()

    fun substituiValor() {
        realizaAlteracao()
    }

    fun realizaAlteracao() {

        try {
            val distance = valueEdit.get().toString()

            if (distance.isNotEmpty())
                resultado.set(distance)

        } catch (ex: Exception) {
            // Toast.makeText(this, , Toast.LENGTH_LONG)
        }

    }

}