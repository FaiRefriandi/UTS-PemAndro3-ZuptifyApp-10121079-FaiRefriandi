package com.froztlass.zuptifyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.replace

class MenuFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        bottomNavigationView = view.findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navHome -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.navDact -> {
                    replaceFragment(DactFragment())
                    true
                }

                R.id.navMusic -> {
                    replaceFragment(MusicFragment())
                    true
                }

                R.id.navGallery -> {
                    replaceFragment(GalleryFragment())
                    true
                }

                R.id.navProfile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
        replaceFragment(HomeFragment())

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}