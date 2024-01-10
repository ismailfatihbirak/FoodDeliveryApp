package com.example.fooddeliveryapp.data.datasource

import com.example.fooddeliveryapp.data.model.FavoriYemekler
import com.example.fooddeliveryapp.room.RoomDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(var rdao:RoomDao) {

    suspend fun favYukle() : List<FavoriYemekler> =
        withContext(Dispatchers.IO){
            return@withContext rdao.favYukle()
        }
    suspend fun favEkle(yemek_adi:String,yemek_fiyat:String,yemek_id:Int,yemek_resim_ad:String){
        var ekle = FavoriYemekler(yemek_id,yemek_adi,yemek_fiyat,yemek_resim_ad,0)
        rdao.favEkle(ekle)
    }
    suspend fun favSil(yemek_id: Int){
        rdao.favSil(yemek_id)
    }
}