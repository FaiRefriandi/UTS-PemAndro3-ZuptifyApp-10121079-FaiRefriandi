package com.froztlass.zuptifyapp

import Friend
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FriendAdapter(private val context: Context, private val friendList: List<Friend>) :
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_item, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend = friendList[position]
        holder.friendNameTextView.text = friend.name
        Glide.with(context)
            .load(friend.photoUrl)
            .placeholder(R.drawable.profilepict)
            .into(holder.friendPhotoImageView)
    }

    override fun getItemCount(): Int = friendList.size

    inner class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friendPhotoImageView: ImageView = itemView.findViewById(R.id.friendPhotoImageView)
        val friendNameTextView: TextView = itemView.findViewById(R.id.friendNameTextView)
    }
}
