package com.hvn.usuario.domain.entities

class Usuario(
    val id: Long?,
    val name: String,
    val localization: String,
    val url: String
) {
    override fun toString(): String {
        return "id : $id, name: $name, location, $localization, url: $url"
    }
}
