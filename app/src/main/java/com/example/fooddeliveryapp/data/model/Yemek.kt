package com.example.fooddeliveryapp.data.model

import java.io.Serializable

data class Yemek (
    val success: Int,
    val yemekler: List<Yemekler>
):Serializable