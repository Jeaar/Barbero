package com.example.barbero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
                    replaceFragment(Purchase_History())
                    true
                }
                else-> false
            }
        }

        binding.sideNav.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    findNavController().navigate(R.id.action_home2_to_profile2)
                }

                R.id.nav_barbers -> {
                    findNavController().navigate(R.id.action_home2_to_barbers2)

                }

                R.id.nav_contact -> {
                    findNavController().navigate(R.id.action_home2_to_contact_Us)

                }

                R.id.nav_about -> {
                    findNavController().navigate(R.id.action_home2_to_aboutUs)

                }
            }
            // Close drawer after item is tapped
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
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
