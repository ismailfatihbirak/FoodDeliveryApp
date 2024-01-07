package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.databinding.FragmentSepetBinding
import com.example.fooddeliveryapp.ui.adapter.SepetAdapter
import com.example.fooddeliveryapp.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.sepetGetir("haypelet")
        viewModel.yemeklerListesi.observe(viewLifecycleOwner){
            var sepetAdapter = SepetAdapter(requireContext(),it,viewModel)
            binding.recyclerView.adapter = sepetAdapter
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel = tempViewModel
    }
}