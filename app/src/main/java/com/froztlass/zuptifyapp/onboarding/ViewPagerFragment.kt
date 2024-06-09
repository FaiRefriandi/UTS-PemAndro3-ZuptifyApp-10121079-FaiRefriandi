package com.froztlass.zuptifyapp.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.froztlass.zuptifyapp.R
import com.froztlass.zuptifyapp.onboarding.screens.FirstScreen
import com.froztlass.zuptifyapp.onboarding.screens.SecondScreen
import com.froztlass.zuptifyapp.onboarding.screens.ThirdScreen

class ViewPagerFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen(),
        )

        // Create the adapter for the ViewPager
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        // Find the ViewPager and set the adapter
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

        return view
    }
}