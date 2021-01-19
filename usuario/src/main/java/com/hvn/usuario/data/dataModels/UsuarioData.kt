package com.hvn.usuario.data.dataModels

import com.google.gson.annotations.SerializedName

data class UsuarioData(
    @SerializedName("url")
    var url: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("avatar_url")
    var avatar_url: String,
    @SerializedName("company")
    val company: String
)