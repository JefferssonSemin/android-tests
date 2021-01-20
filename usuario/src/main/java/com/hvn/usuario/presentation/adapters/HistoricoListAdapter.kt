package com.hvn.usuario.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hvn.usuario.R
import com.hvn.usuario.domain.entities.Usuario
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

class HistoricoListAdapter(private val listaUsuarios: ArrayList<Usuario>) :
    RecyclerView.Adapter<HistoricoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listaUsuarios[position])
    }

    override fun getItemCount() = listaUsuarios.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Usuario) {
            itemView.textView_nome.text = item.name
            itemView.textView_url.text = item.url
        }
    }
}