package com.hvn.ci.test.stepsDefinitions

import android.app.Activity
import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hvn.ci.ui.MainActivity
import com.hvn.ci.test.screenObjects.listDeItensScreen
import io.cucumber.java.es.Dado
import io.cucumber.java.pt.Entao
import org.junit.After
import org.junit.Before
import org.junit.Rule

@LargeTest
class ListaDeItensSteps {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    private var launchedActivity: Activity? = null

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Dado("que o usuário não tenha nada escrito no input")
    fun abrirApp() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.putExtra("parameter", "Value")
        launchedActivity = activityRule.launchActivity(intent)
    }

    @Entao("o usuário deve ver o texto central alterando após digitado e enviado")
    fun substituirMensagemNoCentro() {
        listDeItensScreen {
            validaTela()
        }
    }
}