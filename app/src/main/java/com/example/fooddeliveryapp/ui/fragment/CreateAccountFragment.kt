package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.fooddeliveryapp.databinding.FragmentCreateAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
    //private lateinit var viewModel: CreateAccountViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val tempViewModel: CreateAccountViewModel by viewModels()
        //viewModel = tempViewModel
    }

}