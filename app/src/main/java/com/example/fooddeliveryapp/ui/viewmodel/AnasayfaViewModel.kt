package com.example.fooddeliveryapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var frepo:Repository):ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        anasayfaYemekYukle()
    }

    fun anasayfaYemekYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemeklerListesi.value = frepo.anasayfaYemekYukle()
            }catch (e:Exception){ }
        }
    }
}