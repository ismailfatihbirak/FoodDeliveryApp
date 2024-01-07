package com.example.fooddeliveryapp.data.model

import java.io.Serializable

data class YemekSepet(
    val sepet_yemekler: List<YemeklerSepet>,
    val success: Int

): Serializable
