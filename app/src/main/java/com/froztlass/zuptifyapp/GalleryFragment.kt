package com.froztlass.zuptifyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GalleryAdapter
    private lateinit var imageList: List<Int>
    private lateinit var imageNames: List<String> // Add a list for image names

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2) // 3 columns in grid

        // Initialize image list and names
        imageList = listOf(
            R.drawable.moranizz, // Replace with your actual drawable resource IDs
            R.drawable.theearth,
            R.drawable.manuk,
            R.drawable.malam,
            R.drawable.japart,
            R.drawable.anieye,
            R.drawable.man,
            R.drawable.mamenk,
            // ... add more images
        )

        imageNames = listOf(
            "Monalisa", // Replace with actual image names
            "Eat The Earth",
            "Bird",
            "Starry Night",
            "Japan Art",
            "Anime Eye",
            "Nothing",
            "Cat"
            // ... add more image names
        )

        // Initialize adapter
        adapter = GalleryAdapter(requireContext(), imageList, imageNames)
        recyclerView.adapter = adapter

        return view
    }
}
