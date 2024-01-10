package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.data.model.FavoriYemekler
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.databinding.CardviewBinding
import com.example.fooddeliveryapp.databinding.CardviewFavoriteBinding
import com.example.fooddeliveryapp.ui.viewmodel.FavoriteViewModel

class FavoriteAdapter(var mContext:Context,var resimListeFavorite:List<FavoriYemekler>,var viewModel:FavoriteViewModel) :
    RecyclerView.Adapter<FavoriteAdapter.CardTasarimTutucuFavorite>(){
    inner class CardTasarimTutucuFavorite(var binding: CardviewFavoriteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucuFavorite {
        val binding = CardviewFavoriteBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucuFavorite(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucuFavorite, position: Int) {
        val resim = resimListeFavorite.get(position)
        val t = holder.binding

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${resim.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(t.imageView11)

        t.textView.text = resim.yemek_adi
        t.textView2.text = "₺${resim.yemek_fiyat} fee , 15-30 min"

        t.imageView15.setOnClickListener {
            viewModel.favSil(resim.yemek_id)
        }
    }
    override fun getItemCount(): Int {
        return resimListeFavorite.size
    }
}