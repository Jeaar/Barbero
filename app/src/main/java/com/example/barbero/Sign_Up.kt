package com.example.barbero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentSignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Sign_Up : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        binding.signup.setOnClickListener{
            auth.createUserWithEmailAndPassword(binding.email.text.toString(), binding.password.text.toString())
                .addOnSuccessListener {
                    val path = database.getReference("users")
                    path.child(it.user?.uid.toString()).apply {
                        child("firstname").setValue(binding.firstname.text.toString())
                       child("lastname").setValue(binding.lastname.text.toString())
                       child("phone").setValue(binding.phone.text.toString())
                    }
                    findNavController().navigate(R.id.action_sign_Up_to_home2)
                }
        }
        return binding.root
    }
}
