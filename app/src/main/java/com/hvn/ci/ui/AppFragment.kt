package com.hvn.ci.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hvn.ci.databinding.AppFragmentBinding

class AppFragment : Fragment() {

    private lateinit var binding: AppFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = AppFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAvancar.setOnClickListener {
            val uri = Uri.parse("myApp://detalheUsuarioFragment")
            findNavController().navigate(uri)
            // Navigation.findNavController(it).navigate(R.id.action_appFragment_to_nav_usuario)
        }
    }

}
