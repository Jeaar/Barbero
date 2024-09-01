package com.example.barbero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.barbero.databinding.FragmentProfilePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Profile_Page : Fragment() {

    private lateinit var  binding: FragmentProfilePageBinding

    private  lateinit var auth: FirebaseAuth
    private  lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfilePageBinding.inflate(inflater, container, false)

        return binding.root
    }
}