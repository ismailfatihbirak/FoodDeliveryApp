package com.example.fooddeliveryapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.data.model.YemeklerSepet
import com.example.fooddeliveryapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SepetViewModel @Inject constructor(var frepo: Repository): ViewModel() {
    var yemeklerListesi = MutableLiveData<List<YemeklerSepet>>()

    init {
        sepetGetir("haypelet")
    }
    fun sepetGetir(kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            yemeklerListesi.value = frepo.sepetGetir(kullanici_adi)
        }
    }

    fun sepetSil(sepet_yemek_id:Int,kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch{
            frepo.sepetSil(sepet_yemek_id,kullanici_adi)
            sepetGetir("haypelet")
        }
    }
}