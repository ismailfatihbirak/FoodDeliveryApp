package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.data.model.YemeklerSepet
import com.example.fooddeliveryapp.databinding.FragmentSepetBinding
import com.example.fooddeliveryapp.ui.adapter.SepetAdapter
import com.example.fooddeliveryapp.ui.adapter.SepetItemClickListener
import com.example.fooddeliveryapp.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() , SepetItemClickListener {
    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)

        binding.imageView14.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_sepetFragment_to_anasayfaFragment)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.sepetGetir("haypelet")
        viewModel.yemeklerListesi.observe(viewLifecycleOwner){a->
            var sepetAdapter = SepetAdapter(requireContext(),a,viewModel,this)
            binding.recyclerView.adapter = sepetAdapter

            var toplam = 0
            var tutucu = 0
            for (i in 0 until a.size) {
                toplam = (a[i].yemek_siparis_adet) * a[i].yemek_fiyat
                tutucu += toplam
            }

            binding.textView8.text = "${tutucu} ₺ "
        }





        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onCounterChanged(position: Int, newCount: Int) {
        viewModel.yemeklerListesi.value?.let { b ->
            var tutucu = 0
            for (i in 0 until b.size) {
                val adet = b[i].yemek_siparis_adet ?: 0

                if (i == position) {
                    tutucu += newCount * (b[i].yemek_fiyat ?: 0)
                } else {
                    tutucu += adet * (b[i].yemek_fiyat ?: 0)
                }
            }
            binding.textView8.text = "${tutucu} ₺ "
        }
    }





}