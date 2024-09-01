package com.example.barbero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.barbero.databinding.FragmentHomeBinding

class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        replaceFragment(Home_Page())

        binding. bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_page->{
                    replaceFragment(Home_Page())
                    true
                }
                R.id.purchase_page->{
                    replaceFragment(Hair_Cuts())
                    true
                }
                else-> false
            }
        }

        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
