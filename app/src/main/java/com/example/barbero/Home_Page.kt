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
import androidx.lifecycle.ViewModelProvider

class Home_Page: Fragment() {


    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: ServiceModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View{

       binding = FragmentHomePageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ServiceModel::class.java]


        binding.profile.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_profile2)
        }

        binding.HaircolotNav.setOnClickListener{
            viewModel.service = "Haircolor"

            findNavController().navigate(R.id.action_home2_to_hair_Color)
        }
        binding.ShaveNav.setOnClickListener{
            viewModel.service ="Shave"
            findNavController().navigate(R.id.action_home2_to_shave)
        }
        binding.haircutNav.setOnClickListener{
            viewModel.service = "Haircuts"

            findNavController().navigate(R.id.action_home2_to_hair_Cuts)

        }

        return binding.root

    }


}