package com.example.barbero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentSetAppointmentDetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class SetAppointmentDetails : Fragment() {

    private  lateinit var  binding: FragmentSetAppointmentDetailsBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var  database: FirebaseDatabase



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetAppointmentDetailsBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        binding.done.setOnClickListener{
            val path = database.getReference("Appointments")
            path.child(auth.currentUser?.uid.toString())
                .child(path.push().key.toString())
                .apply {
                    child("service").setValue("sampledata")
                }
        }

        return binding.root


    }
}