package com.example.barbero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Home : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
    
        drawerLayout = view.findViewById(R.id.drawer_layout)
        navigationView = view.findViewById(R.id.side_nav)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {

                    Toast.makeText(activity, "Profile clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_barbers -> {

                    Toast.makeText(activity, "Barbers clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_contact -> {

                    Toast.makeText(activity, "Contact Us clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_about -> {

                    Toast.makeText(activity, "About Us clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        return view
    }
}
