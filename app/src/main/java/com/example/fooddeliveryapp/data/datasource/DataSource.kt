package com.example.fooddeliveryapp.data.datasource

import com.example.fooddeliveryapp.data.model.Yemek
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.data.model.YemeklerSepet
import com.example.fooddeliveryapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSource(var fdao:FoodDao) {
    suspend fun anasayfaYemekYukle() : List<Yemekler> =
        withContext(Dispatchers.IO){
            return@withContext fdao.anasayfaYemekYukle().yemekler
        }

    suspend fun sepetEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:String,yemek_siparis_adet:String,kullanici_adi:String) =
        fdao.sepetEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    suspend fun sepetGetir(kullanici_adi:String) : List<YemeklerSepet> =
        withContext(Dispatchers.IO){
            return@withContext fdao.sepetGetir(kullanici_adi).sepet_yemekler
        }

    suspend fun sepetSil(sepet_yemek_id:Int,kullanici_adi:String) = fdao.sepetSil(sepet_yemek_id,kullanici_adi)
}