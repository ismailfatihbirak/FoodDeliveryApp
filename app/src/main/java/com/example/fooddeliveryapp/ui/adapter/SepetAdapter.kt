package com.example.fooddeliveryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.data.model.YemeklerSepet
import com.example.fooddeliveryapp.databinding.CardviewFavoriteBinding
import com.example.fooddeliveryapp.databinding.CardviewSepetBinding
import com.example.fooddeliveryapp.ui.viewmodel.SepetViewModel

class SepetAdapter(var mContext: Context,var resimListeSepet:List<YemeklerSepet>,var viewModel:SepetViewModel):
    RecyclerView.Adapter<SepetAdapter.CardTasarimTutucuSepet>() {

    inner class CardTasarimTutucuSepet(var binding: CardviewSepetBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucuSepet {
        val binding = CardviewSepetBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucuSepet(binding)
    }
    override fun onBindViewHolder(holder: CardTasarimTutucuSepet, position: Int) {
        val resim = resimListeSepet.get(position)
        val t = holder.binding

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${resim.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(t.imageView21)

        t.textView9.text = resim.yemek_adi
        t.textView10.text = "₺${resim.yemek_fiyat}"
        var sayac = resim.yemek_siparis_adet
        t.textView11.text = sayac.toString()
        t.imageView22.setOnClickListener {
            sayac++
            t.textView11.text = sayac.toString()
        }
        t.imageView23.setOnClickListener {
            if (sayac == 1){
                viewModel.sepetSil(resim.sepet_yemek_id,"haypelet")
            }else{
                sayac--
                t.textView11.text = sayac.toString()
            }
        }

    }
    override fun getItemCount(): Int {
        return resimListeSepet.size
    }
}