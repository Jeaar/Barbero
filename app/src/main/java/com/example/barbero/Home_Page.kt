package com.example.barbero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentHomePageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class Home_Page: Fragment() {


    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View{

       binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.profile.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_profile2)
        }

        binding.haircutNav.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_setAppointmentDetails)
        }
        return binding.root

    }


}