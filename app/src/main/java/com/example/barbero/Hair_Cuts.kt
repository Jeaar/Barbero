package com.example.barbero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentHairCutsBinding

class Hair_Cuts : Fragment() {

    private lateinit var binding: FragmentHairCutsBinding
    private lateinit var  viewModel: ServiceModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHairCutsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ServiceModel::class.java]

        generatebutton(binding.buzzcut, "buzzcut")
        generatebutton(binding.crew, "crew")
        generatebutton(binding.curlyfringe, "fringe")
        generatebutton(binding.comma, "comma")
        generatebutton(binding.undercut,"undercut")
        generatebutton(binding.pompadour,"pompadour")
        generatebutton(binding.taperfade, "taperfade")

        return binding.root
    }

    private fun generatebutton(button: GridLayout, servicename: String){
        button.setOnClickListener{
            viewModel.serviceName = servicename
            findNavController().navigate(R.id.action_hair_Cuts_to_setAppointmentDetails)
        }
    }
}