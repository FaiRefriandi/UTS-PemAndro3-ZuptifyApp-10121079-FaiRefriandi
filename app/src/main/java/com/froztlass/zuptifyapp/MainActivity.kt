package com.froztlass.zuptifyapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)

        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT

        // Set initial status bar icon color based on the background
        setStatusBarIconColor(isLightBackground(Color.WHITE)) // replace with your background color

        // Example usage of Coroutine
        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                // Perform heavy operation here
                performHeavyOperation()
            }
            // Update UI with result
            updateUI(result)
        }
    }

    private fun performHeavyOperation(): String {
        // Heavy operation like accessing database or network
        return "Heavy Operation Result"
    }

    private fun updateUI(result: String) {
        // Update UI with the result of the heavy operation
    }

    private fun setStatusBarIconColor(isLight: Boolean) {
        window.decorView.systemUiVisibility = if (isLight) {
            window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }

    private fun isLightBackground(color: Int): Boolean {
        val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness < 0.5
    }
}
