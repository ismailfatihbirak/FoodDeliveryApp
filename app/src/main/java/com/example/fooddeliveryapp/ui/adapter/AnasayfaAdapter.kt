package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.model.FavoriYemekler
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.databinding.CardviewBinding
import com.example.fooddeliveryapp.ui.fragment.AnasayfaFragment
import com.example.fooddeliveryapp.ui.fragment.AnasayfaFragmentDirections
import com.example.fooddeliveryapp.ui.fragment.FavoriteFragment
import com.example.fooddeliveryapp.ui.viewmodel.AnasayfaViewModel

class AnasayfaAdapter(var mContext: Context,var resimListe:List<Yemekler>,var viewModel:AnasayfaViewModel,var favList:List<FavoriYemekler>) :
    RecyclerView.Adapter<AnasayfaAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var binding: CardviewBinding) : RecyclerView.ViewHolder(binding.root)

    fun setFilteredList(resimListe: List<Yemekler>){
        this.resimListe = resimListe
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardviewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val resim = resimListe.get(position)
        val t = holder.binding

        val isFavorited = favList.any { it.yemek_id == resim.yemek_id.toInt() }
        val isCurrentlyFavorited = favList.any { it.yemek_id == resim.yemek_id.toInt() }
        if (isFavorited) {
            t.imageView24.setImageResource(R.drawable.heart_dolu)
        } else {
            t.imageView24.setImageResource(R.drawable.heart_bos)
        }

        t.imageView24.setOnClickListener {

            Log.d("ClickDebug", "isCurrentlyFavorited: $isCurrentlyFavorited")

            if (isFavorited) {
                Log.d("ClickDebug", "Favorilerden kaldırılıyor")
                t.imageView24.setImageResource(R.drawable.heart_bos)
                viewModel.favSil(resim.yemek_id.toInt())
            } else {
                Log.d("ClickDebug", "Favorilere ekleniyor")
                t.imageView24.setImageResource(R.drawable.heart_dolu)
                viewModel.favEkle(resim.yemek_adi, resim.yemek_fiyat, resim.yemek_id.toInt(), resim.yemek_resim_adi)
            }
        }






        t.cc.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(resim)
            Navigation.findNavController(it).navigate(gecis)
        }


        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${resim.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(t.imageView12)

        t.textView12.text = resim.yemek_adi
        t.textView13.text = "₺${resim.yemek_fiyat}"




    }
    override fun getItemCount(): Int {
        return resimListe.size
    }



}