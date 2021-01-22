package com.hvn.usuario.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Usuario(
    val id: Long?,
    val name: String,
    val localization: String,
    val url: String,
    val url_image: String
) : Parcelable