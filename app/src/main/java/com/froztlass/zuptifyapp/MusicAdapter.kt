package com.froztlass.zuptifyapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MusicAdapter(private val musicList: List<Music>) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCover: ImageView = itemView.findViewById(R.id.img_cover)
        val tvSongName: TextView = itemView.findViewById(R.id.tv_song_name)
        val tvSingerName: TextView = itemView.findViewById(R.id.tv_singer_name)

        fun bind(music: Music) {
            imgCover.setImageResource(music.coverResId)
            tvSongName.text = music.songName
            tvSingerName.text = music.singerName
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(music.songUrl))
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position])
    }

    override fun getItemCount(): Int = musicList.size
}

