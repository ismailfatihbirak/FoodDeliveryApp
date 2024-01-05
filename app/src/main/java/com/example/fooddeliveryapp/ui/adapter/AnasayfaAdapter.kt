package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.data.model.Resim
import com.example.fooddeliveryapp.databinding.CardviewBinding

class AnasayfaAdapter(var mContext: Context,var resimListe:List<Resim>) :
    RecyclerView.Adapter<AnasayfaAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var binding: CardviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardviewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val resim = resimListe.get(position)
        val t = holder.binding

        
    }
    override fun getItemCount(): Int {
        return resimListe.size
    }
}