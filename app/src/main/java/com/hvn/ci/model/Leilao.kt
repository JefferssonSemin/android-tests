package com.hvn.ci.model

class Leilao(
    val descricao: String,
    val lance: List<String>,
    val maiorLance: Double = Double.NEGATIVE_INFINITY
)
