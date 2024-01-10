package com.example.fooddeliveryapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "yemekler")
data class FavoriYemekler(
    @ColumnInfo(name = "yemek_id") @NotNull var yemek_id: Int,
    @ColumnInfo(name = "yemek_adi") @NotNull var yemek_adi: String,
    @ColumnInfo(name = "yemek_fiyat") @NotNull var yemek_fiyat: String,
    @ColumnInfo(name = "yemek_resim_adi") @NotNull var yemek_resim_adi: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "yemek_pri_id") @NotNull var yemek_pri_id: Int
)
