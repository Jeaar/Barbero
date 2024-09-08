package com.example.barbero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentHairColorBinding


class Hair_Color : Fragment() {

    private lateinit var binding: FragmentHairColorBinding
    private lateinit var  viewModel: ServiceModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHairColorBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ServiceModel::class.java]

        generatebutton(binding.blonde, "blonde")
        generatebutton(binding.ombre, "ombre")
        generatebutton(binding.highlights, "highlights")

        return binding.root
    }

    private fun generatebutton(button: GridLayout, servicename: String){
        button.setOnClickListener{
            viewModel.serviceName = servicename
            findNavController().navigate(R.id.action_hair_Color_to_setAppointmentDetails2)
        }
    }
}