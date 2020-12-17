package com.hvn.ci.model

import junit.framework.TestCase

class LeilaoTest : TestCase() {

    fun testGetDescricao() {
        val leilao = Leilao("teste")

        val descricaoDevolvida = leilao.descricao

        assertEquals("teste", descricaoDevolvida)
    }
}