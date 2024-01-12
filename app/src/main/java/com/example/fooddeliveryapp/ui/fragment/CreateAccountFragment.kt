package com.example.fooddeliveryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentCreateAccountBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
    private lateinit var firebaseAuth: FirebaseAuth
    //private lateinit var viewModel: CreateAccountViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonCreate2.setOnClickListener {a->
            val email = binding.editTextText.text.toString()
            val pass = binding.editTextText2.text.toString()
            val confirmPass = binding.editTextText5.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            Navigation.findNavController(a).navigate(R.id.action_createAccountFragment_to_loginFragment)
                        }else{
                            Toast.makeText(requireContext(),it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(requireContext(),"Password is not matching",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(),"Empty Fields Are Not Allowed !!",Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val tempViewModel: CreateAccountViewModel by viewModels()
        //viewModel = tempViewModel
    }

}