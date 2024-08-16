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

class Sign_Up : Fragment() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUpButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign__up, container, false)

        firstName = view.findViewById(R.id.firstname)
        lastName = view.findViewById(R.id.lastname)
        phone = view.findViewById(R.id.phone)
        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)
        signUpButton = view.findViewById(R.id.signup)
        loginTextView = view.findViewById(R.id.login)

        signUpButton.setOnClickListener {
            handleSignUp()
        }

        loginTextView.setOnClickListener {
            navigateToLogIn()
        }

        return view
    }

    private fun handleSignUp() {
        val firstNameText = firstName.text.toString()
        val lastNameText = lastName.text.toString()
        val phoneText = phone.text.toString()
        val emailText = email.text.toString()
        val passwordText = password.text.toString()

        if (firstNameText.isEmpty() || lastNameText.isEmpty() || phoneText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
            Toast.makeText(activity, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(activity, "Sign-Up Successful", Toast.LENGTH_SHORT).show()
            navigateToLogIn()
        }
    }

    private fun navigateToLogIn() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, Log_In())
            ?.addToBackStack(null)
            ?.commit()
    }
}
