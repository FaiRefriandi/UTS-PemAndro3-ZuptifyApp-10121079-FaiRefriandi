package com.froztlass.zuptifyapp

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.graphics.Typeface
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.Calendar

class HomeFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the TextView
        val greetingTextView = view.findViewById<TextView>(R.id.tv_sambutan)

        // Get the user name from SharedPreferences
        val userName = getUserNameFromPreferences()

        // Set the greeting message with formatting
        greetingTextView.text = getGreetingMessage(userName)

        return view
    }

    private fun getUserNameFromPreferences(): String? {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getString("UserName", "Guest")
    }

    private fun getGreetingMessage(userName: String?): CharSequence {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        val greeting = when (hour) {
            in 0..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            else -> "Good Night"
        }

        // Create a SpannableStringBuilder to format the greeting message
        val greetingMessage = "$greeting, $userName!"
        val spannable = SpannableStringBuilder(greetingMessage)

        // Make the greeting bold
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            greeting.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return spannable
    }
}
