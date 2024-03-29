package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.model.FavoriYemekler
import com.example.fooddeliveryapp.data.model.Yemekler
import com.example.fooddeliveryapp.databinding.FragmentAnasayfaBinding
import com.example.fooddeliveryapp.ui.adapter.AnasayfaAdapter
import com.example.fooddeliveryapp.ui.viewmodel.AnasayfaViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

import java.util.Locale


@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    private lateinit var anasayfaAdapter:AnasayfaAdapter
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val backPress = object :OnBackPressedCallback(enabled = true){
            override fun handleOnBackPressed() {
                Navigation.findNavController(requireView()).navigate(R.id.action_anasayfaFragment_to_girisFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPress)

        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.yemeklerListesi.observe(viewLifecycleOwner){

            viewModel.favYemeklerListesi.observe(viewLifecycleOwner){a->
                anasayfaAdapter = AnasayfaAdapter(requireContext(), it, viewModel, a)
                binding.recyclerView2.adapter = anasayfaAdapter
            }

            binding.imageView3.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_girisFragment)
            }
            binding.imageView27.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_favoriteFragment)
            }

            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    filterList(newText,it)
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    filterList(query,it)
                    return true
                }
            })

        }

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_sepetFragment)
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        viewModel.favYukle()
        super.onResume()
    }



    fun filterList(query :String?,it:List<Yemekler>){
        if (query != null){
            val filterList = ArrayList<Yemekler>()
            for (i in it){
                if (i.yemek_adi.lowercase(Locale.ROOT).contains(query)){
                    filterList.add(i)
                }
            }
            if (filterList.isEmpty()){

            }else{
                anasayfaAdapter.setFilteredList(filterList)
            }
        }

    }



}