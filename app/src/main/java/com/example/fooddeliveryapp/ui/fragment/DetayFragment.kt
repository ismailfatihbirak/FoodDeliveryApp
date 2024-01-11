package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentDetayBinding
import com.example.fooddeliveryapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        binding.imageView18.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_detayFragment_to_anasayfaFragment)
        }

        val bundle:DetayFragmentArgs by navArgs()
        bundle.veri

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${bundle.veri.yemek_resim_adi}"
        Glide.with(this).load(url).override(750,750).into(binding.imageView17)

        binding.textView3.text = bundle.veri.yemek_adi
        binding.textView4.text =  "₺ ${bundle.veri.yemek_fiyat}"

        var sayac = 1
        binding.imageView20.setOnClickListener{
            sayac++
            binding.textView5.text = sayac.toString()
        }
        binding.imageView19.setOnClickListener{
            if (sayac != 1 ){
                sayac--
                binding.textView5.text = sayac.toString()
            }

        }
        binding.button.setOnClickListener {
            viewModel.sepetEkle(bundle.veri.yemek_adi,bundle.veri.yemek_resim_adi,bundle.veri.yemek_fiyat,sayac.toString(),"haypelet")
            Navigation.findNavController(it).navigate(R.id.action_detayFragment_to_sepetFragment)
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}