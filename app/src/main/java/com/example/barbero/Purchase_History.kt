package com.example.barbero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.barbero.databinding.FragmentPurchaseHistoryBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class Purchase_History : Fragment() {

    private lateinit var binding: FragmentPurchaseHistoryBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var adapter: PurchaseAdapter
    private lateinit var list: MutableList<Purchase>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPurchaseHistoryBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        list = emptyList<Purchase>().toMutableList()
        adapter = PurchaseAdapter(list)
        binding.purchaseRecyclerView.adapter = adapter

        val path = database.getReference("Appointments").child(auth.currentUser?.uid.toString())
        path.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children){
                    list.add(Purchase(
                        service = snap.child("service").value.toString(),
                        serviceType = snap.child("type").value.toString(),
                        date = snap.child("appointmentdate").value.toString()
                    ))
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        return binding.root
    }
}