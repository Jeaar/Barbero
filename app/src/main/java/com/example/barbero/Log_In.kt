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

class Log_In : Fragment() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var signUpTextView: TextView
    private lateinit var forgotPasswordTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log__in, container, false)

        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)
        loginButton = view.findViewById(R.id.login)
        signUpTextView = view.findViewById(R.id.signup)
        forgotPasswordTextView = view.findViewById(R.id.forgot_password)

        loginButton.setOnClickListener {
            handleLogin()
        }

        signUpTextView.setOnClickListener {
            navigateToSignUp()
        }

        forgotPasswordTextView.setOnClickListener {
            handleForgotPassword()
        }

        return view
    }

    private fun handleLogin() {
        val emailText = email.text.toString()
        val passwordText = password.text.toString()

        if (emailText.isEmpty() || passwordText.isEmpty()) {
            Toast.makeText(activity, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(activity, "Login Successful", Toast.LENGTH_SHORT).show()
            navigateToHome()
        }
    }

    private fun navigateToSignUp() {

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, Sign_Up())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToHome() {

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, Home())
            ?.commit()
    }

    private fun handleForgotPassword() {
        // Handle forgot password action
        Toast.makeText(activity, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
    }
}
