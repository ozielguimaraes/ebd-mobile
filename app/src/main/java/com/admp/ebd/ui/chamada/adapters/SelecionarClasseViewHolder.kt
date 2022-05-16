package com.admp.ebd.ui.chamada.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.admp.ebd.data.remote.entities.turma.TurmaRemoteEntity

class SelecionarClasseViewHolder (private val view: View): RecyclerView.ViewHolder(view)  {
    open val textViewNome: TextView by lazy {
        view.findViewById(R)
    }
    open fun onBind(item: TurmaRemoteEntity) {

    }
}