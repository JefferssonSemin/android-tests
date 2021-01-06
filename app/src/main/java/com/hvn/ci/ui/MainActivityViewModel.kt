package com.hvn.ci.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvn.ci.domain.usecases.BuscarUsuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(
    private val buscarUsuario: BuscarUsuario
) : ViewModel() {

    private val valueEdit: ObservableField<String> = ObservableField()
    private val resultado: ObservableField<String> = ObservableField()

    fun substituiValor() {
        realizaAlteracao()
    }

    fun realizaAlteracao() {
        viewModelScope.launch {
            val estado =
                withContext(Dispatchers.Default) { buscarUsuario.invoke("JefferssonSemin") }

            resultado.set("")
        }
    }

}