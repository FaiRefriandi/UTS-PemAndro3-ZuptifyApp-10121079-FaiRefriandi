package com.froztlass.zuptifyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusicFragment : Fragment() {
    // Fa'i Refriandi - 10121079
    // PemAndro3 - 09/06/2024
    // Tugas Besar UTS
    private lateinit var recyclerView: RecyclerView
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var musicList: List<Music>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)

        // Sample data
        musicList = listOf(
            Music(R.drawable.cov_yoasobi1, "あの夢をなぞって", "YOASOBI", "https://music.youtube.com/watch?v=iAOTwdlEdVg&si=H0prIjK7ui8HVgrt"),
            Music(R.drawable.cover_almotsis, "Almost Is Never Enough", "Ariana Grande & Nathan Sykes", "https://music.youtube.com/watch?v=TKVsRBjMWuk&si=_FDq9mVLoec1hDEQ"),
            Music(R.drawable.cov_athousandyears, "A Thousand Years", "James Arthur", "https://music.youtube.com/watch?v=aJa_qcRroM8&si=m7WxNoLPtm3vmbws"),
            Music(R.drawable.cov_backtous, "Back To Us", "Keenan Te", "https://music.youtube.com/watch?v=DRIkebnh8Z4&si=W8pDn74tEiQcw63a"),
            Music(R.drawable.cov_caibehim, "Can I Be Him", "James Arthur", "https://music.youtube.com/watch?v=L3dPK8tDn6g&si=tZcpoYzZjShmYt70"),
            Music(R.drawable.cov_drunktext, "Drunk Text", "Henry Moodie", "https://music.youtube.com/watch?v=bokJfDZCzNk&si=a5KEUPyxqZgh38MB"),
            Music(R.drawable.cov_echo, "Echo (Acoustic)", "Alexander Stewart", "https://music.youtube.com/watch?v=334LT8WKaOU&si=g8bOQ7OjuhiLtYWz"),
            Music(R.drawable.cov_emptyspace, "Empty Space", "James Arthur", "https://music.youtube.com/watch?v=rXoTc7WkuyQ&si=FUamjxD1D3eq6zM6"),
            Music(R.drawable.cov_faults, "Faults", "Keenan Te", "https://music.youtube.com/watch?v=AT4681VIYJk&si=Ag3dnVsUObA6RCCP"),
            Music(R.drawable.cov_heresyouperfect, "Here's You Perfect", "Jamie Miller", "https://music.youtube.com/watch?v=cRi-x2r88no&si=if3lbYsEubgw3Qv9"),
            Music(R.drawable.cov_inthestars, "In The Stars", "Benson Boone", "https://music.youtube.com/watch?v=IESmnavb5wY&si=HduPSZnVp2p5t9NB"),
            Music(R.drawable.cov_nobodygetsme, "Nobody Gets Me", "SZA", "https://music.youtube.com/watch?v=2NyIupIueAY&si=lac0gI9X967njVV8"),
            Music(R.drawable.cov_perfectonme, "Perfect For Me", "Bradley Marshall", "https://music.youtube.com/watch?v=4kLR7o5g2Ys&si=1in5maF4Jl1b_v_M"),
            Music(R.drawable.cov_spendit, "Spend It With You", "Kodaline", "https://music.youtube.com/watch?v=RNHKNYcqa08&si=NhDXRRxYxuZ3ObTs"),
            Music(R.drawable.cov_stuckwithu, "Stuck With U", "Justin Bieber & Ariana Grande", "https://music.youtube.com/watch?v=yEA3qaB0dH8&si=W1i5vFiyUbkV0pnP"),
        )

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        return view
    }
}

