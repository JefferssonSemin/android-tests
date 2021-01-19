package com.hvn.usuario.data.dataModels

import com.google.gson.annotations.SerializedName

data class ResponseData<T>(
    val mensagem: String = "",
    val modelo: T?,
    val sucesso: Boolean = true

)