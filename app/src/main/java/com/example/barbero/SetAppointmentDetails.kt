package com.example.barbero

import android.app.Service
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentSetAppointmentDetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class SetAppointmentDetails : Fragment() {

    private  lateinit var  binding: FragmentSetAppointmentDetailsBinding
    private lateinit var viewModel: ServiceModel
    private lateinit var auth: FirebaseAuth
    private lateinit var  database: FirebaseDatabase
    


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetAppointmentDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ServiceModel::class.java]
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        var date = ""
        binding.done.setOnClickListener{
            if (date.isNullOrEmpty()){
                Toast.makeText(requireContext(), "select date", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val path = database.getReference("Appointments")
            path.child(auth.currentUser?.uid.toString())
                .child(path.push().key.toString())
                .apply {
                    child("service").setValue(viewModel.service)
                    child("type").setValue(viewModel.serviceName)
                    child("appointmentdate").setValue(date)
                }
            findNavController().navigate(R.id.action_setAppointmentDetails_to_appointment_Done2)
        }
        binding.datePicker.setOnDateChangeListener { calendarView, year, months, day ->
            date =
                "${months + 1}-$day-$year "
        }
        return binding.root


    }
}