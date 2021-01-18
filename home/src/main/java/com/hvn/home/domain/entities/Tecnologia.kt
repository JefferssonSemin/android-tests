package com.hvn.home.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Tecnologia(
    var nome: String,
    var descricao: String
) : Parcelable