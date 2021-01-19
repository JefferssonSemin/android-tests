package com.hvn.usuario.data.remote

import com.google.gson.annotations.SerializedName

data class UsuarioData(
    @SerializedName("login")
    var login: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("avatar_url")
    var avatar_url: String
)