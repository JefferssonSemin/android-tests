package com.hvn.ci.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assumptions.assumingThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

class LeilaoTest {

    private val leilao: Leilao = Leilao()

    @DisplayName("Valida descrição ")
    @Test
    fun testGetDescricao() {
        val leilao = Leilao("teste")

        val descricaoDevolvida = leilao.descricao

        assertEquals("teste", descricaoDevolvida)
        assertTrue(descricaoDevolvida.length == 5)

    }

    @Disabled("por conta de tetse")
    @Test
    fun exceptionTesting() {
        val exception: Exception = assertThrows(java.lang.Exception::class.java) {
        }
        assertEquals("/ by zero", exception.message)
    }

    @DisplayName("Cenario perfeito")
    @Test
    fun testInAllEnvironments() {
        val ferias = Leilao("30diasoff")

        val descricaoDevolvida = ferias.descricao

        assumingThat(
            "empresaBoa" == System.getenv("PV")
        ) {
            assertEquals("1dayoff", descricaoDevolvida)
        }
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    fun notOnDeveloperWorkstation() {
        // ...
    }
}