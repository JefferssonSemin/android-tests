package com.hvn.ci.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hvn.ci.R
import com.hvn.ci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.buttonAlteraNome.setOnClickListener {
            viewModel.substituiValor()
            //val input = findViewById<TextInputEditText>(R.id.editTextUserInput)
            // val text = findViewById<TextView>(R.id.textToBeChanged)

            //text.text = input.text.toString()
        }

        binding.buttonLimpar.setOnClickListener {
            binding.textTextoCentral.clearComposingText()
        }
    }
}