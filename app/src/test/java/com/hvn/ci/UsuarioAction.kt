package com.hvn.ci

import com.hvn.ci.utils.validaUsuario
import junit.framework.Assert.assertEquals
import org.junit.Test

class UsuarioAction {

    @Test
    fun teste_buttonLimpar() {

        // arrange
        val esperado = true

        // act
        val atual = validaUsuario("Joao")


        // assert
        assertEquals(esperado, atual)
    }

}