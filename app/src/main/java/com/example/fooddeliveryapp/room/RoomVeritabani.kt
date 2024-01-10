package com.example.fooddeliveryapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fooddeliveryapp.data.model.FavoriYemekler

@Database(entities = [FavoriYemekler::class], version = 1)
abstract class RoomVeritabani :RoomDatabase(){
    abstract fun getRoomDao() : RoomDao
}