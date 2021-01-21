package com.hvn.usuario.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hvn.usuario.data.room.DataManager
import com.hvn.usuario.data.room.DatabaseHelper
import com.hvn.usuario.databinding.HistoricoFragmentBinding
import com.hvn.usuario.presentation.adapters.HistoricoListAdapter

class HistoricoFragment : Fragment() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var binding: HistoricoFragmentBinding
    private lateinit var adaptador: HistoricoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        databaseHelper = DatabaseHelper(requireContext())

        binding = HistoricoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        adaptador = HistoricoListAdapter(DataManager.buscaTodosUsuarios(databaseHelper))
        binding.recyclerUsuarios.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = adaptador
        }
    }

}