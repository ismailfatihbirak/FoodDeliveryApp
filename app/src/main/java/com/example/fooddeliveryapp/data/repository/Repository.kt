package com.example.fooddeliveryapp.data.repository

import com.example.fooddeliveryapp.data.datasource.DataSource

class Repository(var fds:DataSource) {
    suspend fun anasayfaYemekYukle() = fds.anasayfaYemekYukle()
    suspend fun sepetEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:String,yemek_siparis_adet:String,kullanici_adi:String) =
        fds.sepetEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    suspend fun sepetGetir(kullanici_adi:String) = fds.sepetGetir(kullanici_adi)
    suspend fun sepetSil(sepet_yemek_id:Int,kullanici_adi:String) = fds.sepetSil(sepet_yemek_id,kullanici_adi)
}