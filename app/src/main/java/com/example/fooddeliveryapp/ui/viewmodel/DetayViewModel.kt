package com.example.fooddeliveryapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel@Inject constructor(var frepo: Repository):ViewModel() {
    fun sepetEkle(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:String, yemek_siparis_adet:String, kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.sepetEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
    }

}