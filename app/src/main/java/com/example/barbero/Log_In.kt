package com.example.barbero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentLogInBinding
import com.google.firebase.auth.FirebaseAuth

class Log_In : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        auth.currentUser?.let {
            findNavController().navigate(R.id.action_log_In_to_home2)
        }

        binding.login.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                showToast("Please fill in both email and password")
            } else {
                signIn(email, password)
            }
        }

        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_log_In_to_sign_Up)
        }

        return binding.root
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                findNavController().navigate(R.id.action_log_In_to_home2)
                showToast("Log In Successful")
            }
            .addOnFailureListener { exception ->
                showToast("Login Failed: ${exception.message}")
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}
