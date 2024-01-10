package com.example.fooddeliveryapp.data.repository

import com.example.fooddeliveryapp.data.datasource.RoomDataSource

class RoomRepository(var rds:RoomDataSource) {
    suspend fun favYukle() = rds.favYukle()
    suspend fun favEkle(yemek_adi:String,yemek_fiyat:String,yemek_id:Int,yemek_resim_ad:String) =
        rds.favEkle(yemek_adi,yemek_fiyat,yemek_id,yemek_resim_ad)

    suspend fun favSil(yemek_id: Int) = rds.favSil(yemek_id)
}