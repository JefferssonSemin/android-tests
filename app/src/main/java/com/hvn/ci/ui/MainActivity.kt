package com.hvn.ci.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.hvn.ci.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val botao = findViewById<Button>(R.id.changeTextBt)
        val botaoExcluir = findViewById<Button>(R.id.buttonLimpar)

        botao.setOnClickListener {
            viewModel.substituiValor()
            //val input = findViewById<TextInputEditText>(R.id.editTextUserInput)
            // val text = findViewById<TextView>(R.id.textToBeChanged)

            //text.text = input.text.toString()
        }

        botaoExcluir.setOnClickListener {
            val text = findViewById<TextView>(R.id.textToBeChanged)

            text.text = ""
        }
    }
}