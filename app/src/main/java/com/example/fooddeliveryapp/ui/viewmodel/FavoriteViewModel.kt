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
class FavoriteViewModel @Inject constructor(var roomRepo: RoomRepository): ViewModel(){
    var yemeklerListesi = MutableLiveData<List<FavoriYemekler>>()

    init {
        favYukle()
    }
    fun favYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemeklerListesi.value = roomRepo.favYukle()
            }catch (e:Exception){ }
        }
    }

    fun favSil(yemek_id:Int){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                roomRepo.favSil(yemek_id)
            }catch (e:Exception){ }
        }
        favYukle()
    }

}