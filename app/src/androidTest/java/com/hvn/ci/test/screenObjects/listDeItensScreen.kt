package com.hvn.ci.test.screenObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.hvn.ci.R

fun listDeItensScreen(func: listDeItensScreen.() -> Unit) = listDeItensScreen().apply { func() }
class listDeItensScreen {

    val textoASerDigitado = "espreso"
    val stringVazia = ""
    val textoCentral = R.id.textToBeChanged
    val botaoEnviar = R.id.changeTextBt
    val botaoLimpar = R.id.buttonLimpar
    val inputNome = R.id.editTextUserInput

    fun limpa_text() {

        onView(withId(botaoLimpar)).perform(click())

        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(stringVazia)))
    }

    fun validaTela() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(textoASerDigitado), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(textoASerDigitado)))
    }

    fun clica_botao() {
        onView(withId(botaoEnviar)).perform(click())
    }

    fun verifica_input() {
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(textoASerDigitado), closeSoftKeyboard())
    }
}