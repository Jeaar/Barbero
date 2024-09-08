package com.example.barbero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentShaveBinding

class Shave : Fragment() {

    private lateinit var binding: FragmentShaveBinding
    private lateinit var viewModel: ServiceModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShaveBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ServiceModel::class.java]

        generatebutton(binding.circlebeard, "circlebeard")
        generatebutton(binding.stubblebeard, "stubblebeard")
        generatebutton(binding.shortboxedbeard, "shortboxedbeard")
        return binding.root
    }
    private fun generatebutton(button: GridLayout, servicename: String){
        button.setOnClickListener{
            viewModel.serviceName = servicename
            findNavController().navigate(R.id.action_shave_to_setAppointmentDetails)
        }
    }
}