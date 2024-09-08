package com.example.barbero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.barbero.databinding.FragmentProfileBinding
import com.example.barbero.databinding.FragmentProfilePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Profile : Fragment() {

    private lateinit var  binding: FragmentProfileBinding

    private  lateinit var auth: FirebaseAuth
    private  lateinit var database: FirebaseDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val path = database.getReference("users").child(auth.currentUser?.uid.toString())
        path.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.name.setText(snapshot.child("firstname").value.toString())
                binding.number.setText(snapshot.child("phone").value.toString())
                binding.email.setText(auth.currentUser?.email.toString())
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        binding.logout.setOnClickListener{
            auth.signOut()
            findNavController().navigate(R.id.action_profile2_to_log_In)
        }
        return binding.root
    }
}