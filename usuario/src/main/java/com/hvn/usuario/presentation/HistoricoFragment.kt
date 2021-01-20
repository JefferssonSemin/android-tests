package com.hvn.usuario.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hvn.usuario.R

class HistoricoFragment : Fragment() {

    companion object {
        fun newInstance() = HistoricoFragment()
    }

    private lateinit var viewModel: HistoricoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.historico_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistoricoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}