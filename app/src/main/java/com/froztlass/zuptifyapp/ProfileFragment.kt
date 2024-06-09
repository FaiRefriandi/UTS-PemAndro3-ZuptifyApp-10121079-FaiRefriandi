package com.froztlass.zuptifyapp

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.squareup.picasso.BuildConfig

class ProfileFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val cardContact: CardView = view.findViewById(R.id.card_contact)
        val cardGmail: CardView = view.findViewById(R.id.card_gmail)
        val cardWhatsApp: CardView = view.findViewById(R.id.card_whatsapp)
        val cardSocial: CardView = view.findViewById(R.id.card_social)
        val cardVersion: CardView = view.findViewById(R.id.card_version)
        val cardMaps: CardView = view.findViewById(R.id.card_maps)

        cardContact.setOnClickListener { openContact() }
        cardGmail.setOnClickListener { openGmail() }
        cardWhatsApp.setOnClickListener { openWhatsApp() }
        cardSocial.setOnClickListener { openSocial() }
        cardVersion.setOnClickListener { showAppVersionDialog() }
        cardMaps.setOnClickListener { openGoogleMaps() }

        return view
    }

    private fun openContact() {
        val phoneNumber = "+6281906523262"
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    private fun openGmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("fairefriandi665@gmail.com"))
        }
        startActivity(intent)
    }

    private fun openWhatsApp() {
        val phoneNumber = "+6281906523262"
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/$phoneNumber")
        }
        startActivity(intent)
    }

    private fun openSocial() {
        val uri = Uri.parse("https://www.facebook.com/fairefriandi")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun openGoogleMaps() {
        val uri = Uri.parse("https://maps.app.goo.gl/UHBLkb5mTJww5HDX7")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun showAppVersionDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog)

        // Custom logo
        val logoImageView: ImageView = dialog.findViewById(R.id.logoImageView)
        logoImageView.setImageResource(R.drawable.splash)

        // Version info
        val versionTextView: TextView = dialog.findViewById(R.id.versionTextView)
        versionTextView.text = "Versi 1.0"

        // Dialog info
        val dialogTextView: TextView = dialog.findViewById(R.id.dialogTextView)
        dialogTextView.text = "Aplikasi ini dibuat dengan sepenuh hati"

        dialog.show()
    }
}
