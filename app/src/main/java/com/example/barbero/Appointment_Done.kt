package com.example.barbero

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class Appointment_Done : Fragment() {

    private lateinit var timerTextView: TextView
    private var countdownTime = 6

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_appointment__done, container, false)
        timerTextView = view.findViewById(R.id.timer_text)
        startCountdown()
        return view
    }

    private fun startCountdown() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                if (countdownTime > 0) {
                    timerTextView.text = "Returning to Home Page in ${countdownTime-1} seconds"
                    countdownTime--
                    handler.postDelayed(this, 1000)
                } else {
                    findNavController().navigate(R.id.action_appointment_Done2_to_home2)
                }
            }
        }
        handler.post(runnable)
    }
}