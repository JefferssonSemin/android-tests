package com.hvn.usuario.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hvn.usuario.R
import com.hvn.usuario.data.room.DataManager
import com.hvn.usuario.data.room.DatabaseHelper
import com.hvn.usuario.domain.entities.Usuario
import com.hvn.usuario.presentation.fragments.HistoricoFragmentDirections
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

class HistoricoListAdapter(private val listaUsuarios: ArrayList<Usuario>) :
    RecyclerView.Adapter<HistoricoListAdapter.ViewHolder>() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        databaseHelper = DatabaseHelper(parent.context)
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listaUsuarios[position])
        holder.setListener(listaUsuarios[position].id)
    }

    override fun getItemCount() = listaUsuarios.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Usuario) {
            itemView.textView_nome.text = item.name
            itemView.textView_url.text = item.url
        }

        fun setListener(id: Long?) {
            itemView.setOnClickListener {
                val usuario = DataManager.buscaUsuarioPorId(databaseHelper, id.toString())

                val action =
                    HistoricoFragmentDirections.actionHistoricoFragmentToDetalhesUsuarioFragment(
                        usuario = usuario
                    )

                itemView.findNavController().navigate(action)
            }
        }
    }
}