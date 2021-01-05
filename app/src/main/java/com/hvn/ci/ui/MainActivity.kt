package com.hvn.ci.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hvn.ci.R
import com.hvn.ci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoAlterarNome = findViewById<Button>(R.id.button_altera_nome)
        val botaoLimpar = findViewById<Button>(R.id.button_limpar)

        botaoAlterarNome.setOnClickListener {
            //val input = findViewById<TextInputEditText>(R.id.editTextUserInput)
            // val text = findViewById<TextView>(R.id.textToBeChanged)

            //text.text = input.text.toString()
        }

        botaoLimpar.setOnClickListener {
            val textoCentral = findViewById<TextView>(R.id.text_texto_central)

            textoCentral.text = ""
        }
    }
}