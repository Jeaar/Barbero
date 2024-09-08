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
import com.example.barbero.databinding.FragmentLogInBinding
import com.example.barbero.databinding.FragmentSignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Log_In : Fragment() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null){
            findNavController().navigate(R.id.action_log_In_to_home2)
        }
        binding.login.setOnClickListener{

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                findNavController().navigate(R.id.action_log_In_to_home2)

                Toast.makeText(requireContext(), "Log In Successful", Toast.LENGTH_LONG).show()
            } .addOnFailureListener{

                Toast.makeText(requireContext(), "Try Again", Toast.LENGTH_LONG).show()
            }
        }
        binding.signup.setOnClickListener{
            findNavController().navigate(R.id.action_log_In_to_sign_Up)
        }
        return binding.root
    }
}


