package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.databinding.CardviewBinding
import com.example.fooddeliveryapp.ui.fragment.AnasayfaFragment
import com.example.fooddeliveryapp.ui.fragment.AnasayfaFragmentDirections

class AnasayfaAdapter(var mContext: Context,var resimListe:List<Yemekler>) :
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

        t.cc.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(resim)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.imageView24.setOnClickListener{
            if (t.imageView24.drawable == ContextCompat.getDrawable(mContext, R.drawable.heart_dolu)) {
                t.imageView24.setImageResource(R.drawable.heart_bos)
            } else {
                t.imageView24.setImageResource(R.drawable.heart_dolu)
                val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToFavoriteFragment(resim)
                Navigation.findNavController(it).navigate(gecis)
            }
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