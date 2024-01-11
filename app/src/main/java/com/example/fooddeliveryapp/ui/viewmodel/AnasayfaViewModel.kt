package com.example.fooddeliveryapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.data.model.FavoriYemekler
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.data.repository.Repository
import com.example.fooddeliveryapp.data.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var frepo:Repository,var roomRepo:RoomRepository):ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var favYemeklerListesi = MutableLiveData<List<FavoriYemekler>>()

    init {
        anasayfaYemekYukle()
        favYukle()
    }

    fun anasayfaYemekYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemeklerListesi.value = frepo.anasayfaYemekYukle()
            }catch (e:Exception){ }
        }

    }
    fun favYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                favYemeklerListesi.value = roomRepo.favYukle()
            }catch (e:Exception){ }
        }
    }

    fun favEkle(yemek_adi:String,yemek_fiyat:String,yemek_id:Int,yemek_resim_ad:String){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                roomRepo.favEkle(yemek_adi,yemek_fiyat,yemek_id,yemek_resim_ad)
            }catch (e:Exception){ }
            favYukle()
        }
    }

    fun favSil(yemek_id:Int){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                roomRepo.favSil(yemek_id)
            }catch (e:Exception){ }
            favYukle()
        }
    }


}