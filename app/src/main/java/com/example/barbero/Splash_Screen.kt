package com.example.barbero

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentSplashScreenBinding
import com.google.firebase.auth.FirebaseAuth



class Splash_Screen : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        Handler(Looper.getMainLooper()).postDelayed({
            if (auth.currentUser == null) {
                findNavController().navigate(R.id.action_splash_Screen_to_log_In)
            } else {
                findNavController().navigate(R.id.action_splash_Screen_to_home2)
            }
        }, 1500)

        return binding.root
    }
}
