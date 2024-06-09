package com.froztlass.zuptifyapp.onboarding.screens

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.froztlass.zuptifyapp.R

class ThirdScreen : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)

        val finishTextView = view.findViewById<TextView>(R.id.finish)
        val userNameEditText = view.findViewById<EditText>(R.id.et_user_name)

        finishTextView.setOnClickListener {
            val userName = userNameEditText.text.toString()
            if (userName.isBlank()) {
                Toast.makeText(requireContext(), "Please enter your username", Toast.LENGTH_SHORT).show()
            } else {
                saveUserNameToPreferences(userName)
                findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
                onBoardingFinished()
            }
        }

        userNameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                finishTextView.isEnabled = !s.isNullOrBlank()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // Adjust view when keyboard is shown
        view.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.rootView.height
            val keypadHeight = screenHeight - rect.bottom

            if (keypadHeight > screenHeight * 0.15) {
                view.scrollTo(0, keypadHeight)
            } else {
                view.scrollTo(0, 0)
            }
        }

        // Handle Enter key press
        userNameEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                event?.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER) {
                // Do nothing
                true
            } else {
                false
            }
        }

        return view
    }

    private fun saveUserNameToPreferences(userName: String) {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("UserName", userName)
        editor.apply()
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}
