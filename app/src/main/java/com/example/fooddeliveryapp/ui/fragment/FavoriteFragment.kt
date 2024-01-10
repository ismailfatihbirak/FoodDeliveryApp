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
import com.example.fooddeliveryapp.databinding.FragmentFavoriteBinding
import com.example.fooddeliveryapp.ui.adapter.FavoriteAdapter
import com.example.fooddeliveryapp.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteAdapter : FavoriteAdapter
    private lateinit var viewModel: FavoriteViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())


        viewModel.yemeklerListesi.observe(viewLifecycleOwner){
            favoriteAdapter = FavoriteAdapter(requireContext(),it,viewModel)
            binding.rv.adapter = favoriteAdapter
        }
        binding.imageView8.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_favoriteFragment_to_anasayfaFragment)
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FavoriteViewModel by viewModels()
        viewModel = tempViewModel

    }


}