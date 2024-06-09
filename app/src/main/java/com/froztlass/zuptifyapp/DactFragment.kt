package com.froztlass.zuptifyapp

import Friend
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class DactFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the references to the CalendarView and the TextView
        val calendarView: CalendarView = view.findViewById(R.id.calendarView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val friendRecyclerView: RecyclerView = view.findViewById(R.id.friendRecyclerView)

        // Disable the CalendarView to prevent date selection
        calendarView.isEnabled = false

        // Get the current date
        val calendar = Calendar.getInstance()
        val currentDate = calendar.timeInMillis

        // Format the current date to include day name, month, and year
        val dateFormat = SimpleDateFormat("EEEE, d MMMM yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(Date(currentDate))

        // Create a SpannableStringBuilder to apply different text styles
        val builder = SpannableStringBuilder()

        // Append "Today is" with normal style
        builder.append("Today is ")

        // Append the formatted date with bold style
        val dateStartIndex = builder.length
        builder.append(formattedDate)
        builder.setSpan(
            StyleSpan(android.graphics.Typeface.BOLD),
            dateStartIndex,
            builder.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Set the styled text to the TextView
        dateTextView.text = builder

        // Set the current date to the CalendarView
        calendarView.date = currentDate

        // Sample list of daily activities
        val dailyActivityList = listOf(
            "Bangun Pagi                                             04:30",
            "Mandi                                                         05:30",
            "Sarapan Pagi                                           06:30",
            "Berangkat ke Kampus                            07:00",
            "Mengikuti Perkuliahan                            08:30",
            "Makan Siang                                              12:30",
            "Mengikuti Kegiatan UKM                         16:00",
            "Makan Malam                                           19:00",
            "Belajar & Istirahat                   20:00 - Selesai",
            "Istirahat"
            // Add more activities as needed
        )

        // Sample list of friends with their photos
        val friendList = listOf(
            Friend("Hary Kurniawan", "https://example.com/john.jpg"),
            Friend("Rahmatahalu", "https://example.com/jane.jpg"),
            Friend("Wildan Permana", "https://example.com/alice.jpg"),
            Friend("Selamet Riyadi", "https://example.com/bob.jpg"),
            Friend("Reza Pahlevi", "https://example.com/charlie.jpg")
            // Add more friends as needed
        )

        // Set up the RecyclerViews with the adapters
        recyclerView.adapter = DailyActivityAdapter(dailyActivityList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        friendRecyclerView.adapter = FriendAdapter(requireContext(), friendList)
        friendRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Calculate total height of all items in RecyclerView
        val recyclerViewHeight = calculateRecyclerViewHeight(recyclerView)

        // Set the height of RecyclerView
        recyclerView.layoutParams.height = recyclerViewHeight
    }

    private fun calculateRecyclerViewHeight(recyclerView: RecyclerView): Int {
        val adapter = recyclerView.adapter
        var totalHeight = 0
        if (adapter != null) {
            for (i in 0 until adapter.itemCount) {
                val view =
                    adapter.onCreateViewHolder(recyclerView, adapter.getItemViewType(i)).itemView
                adapter.onBindViewHolder(
                    adapter.createViewHolder(
                        recyclerView,
                        adapter.getItemViewType(i)
                    ), i
                )
                view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
                totalHeight += view.measuredHeight
            }
        }
        return totalHeight
    }
}
