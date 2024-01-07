package com.example.fooddeliveryapp.retrofit

import com.example.fooddeliveryapp.data.model.EkleGetirSilCevap
import com.example.fooddeliveryapp.data.model.Yemek
import com.example.fooddeliveryapp.data.model.YemekSepet
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun anasayfaYemekYukle() : Yemek

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepetEkle(@Field("yemek_adi") yemek_adi:String,
                       @Field("yemek_resim_adi") yemek_resim_adi:String,
                       @Field("yemek_fiyat") yemek_fiyat:String,
                       @Field("yemek_siparis_adet") yemek_siparis_adet:String,
                       @Field("kullanici_adi") kullanici_adi:String) : EkleGetirSilCevap

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sepetGetir(@Field("kullanici_adi") kullanici_adi:String ): YemekSepet

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sepetSil(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                         @Field("kullanici_adi") kullanici_adi:String) : EkleGetirSilCevap


}