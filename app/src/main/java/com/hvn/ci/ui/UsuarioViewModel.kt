package com.hvn.ci.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.hvn.ci.domain.entities.Usuario
import com.hvn.ci.domain.usecases.BuscarUsuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel(
    private val buscarUsuario: BuscarUsuario
) : ViewModel() {
    class Factory(
        private val buscarUsuario: BuscarUsuario,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UsuarioViewModel::class.java)) {
                return UsuarioViewModel(buscarUsuario) as T
            }
            throw IllegalArgumentException("ViewModel not found.")
        }
    }

    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> = _usuario

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