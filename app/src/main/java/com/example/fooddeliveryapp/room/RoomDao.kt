package com.example.fooddeliveryapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.fooddeliveryapp.data.model.FavoriYemekler

@Dao
interface RoomDao {
    @Query("SELECT * FROM yemekler")
    suspend fun favYukle() : List<FavoriYemekler>

    @Insert
    suspend fun favEkle(favYemek:FavoriYemekler)

    @Query("DELETE FROM yemekler WHERE yemek_id = :yemek_id")
    suspend fun  favSil(yemek_id:Int)
}