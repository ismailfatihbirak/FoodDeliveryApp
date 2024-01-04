package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentGirisBinding


class GirisFragment : Fragment() {
    private lateinit var binding: FragmentGirisBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGirisBinding.inflate(inflater, container, false)

        binding.buttonCreate.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_girisFragment_to_createAccountFragment)
        }
        binding.buttonLogin.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_girisFragment_to_loginFragment)
        }
        return binding.root
    }


}