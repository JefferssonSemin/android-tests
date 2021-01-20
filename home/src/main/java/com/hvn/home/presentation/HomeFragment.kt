package com.hvn.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hvn.home.databinding.HomeFragmentBinding
import com.hvn.home.databinding.HomeFragmentBindingImpl
import com.hvn.home.domain.entities.Tecnologia

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTecnologias.setOnClickListener {
            val model = Tecnologia("Kotlin", "Uma linguagem de programacao")
            val action = HomeFragmentDirections.actionHomeFragmentToTecnologiasFragment(model.nome)
            findNavController().navigate(action)
        }
    }
}