package com.hvn.ci

import com.hvn.ci.utils.validaUsuario
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class UsuarioAction(
    private val esperado: Boolean,
    private val nomeCerto: String,
    private val nomeErrado: String
) {
    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(true, "Joao", "Rick"),
            arrayOf(true, "Jeffersson", "Anderson"),
            arrayOf(true, "Zeta", "Eliton")
        )
    }

    @Test
    fun test_validaUsuario() {
        // act
        val atual = validaUsuario(nomeCerto)

        // assert
        assertEquals(esperado, atual)
    }

    @Test
    fun test_naoValidaUsuario() {
        // act
        val atual = validaUsuario(nomeErrado)

        // assert
        assertNotEquals(esperado, atual)
    }
}