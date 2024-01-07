package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    //private lateinit var viewModel: LoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.buttonCreate2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_anasayfaFragment)
        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val tempViewModel: LoginViewModel by viewModels()
        //viewModel = tempViewModel
    }
}