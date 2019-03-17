package com.example.yunus.youtubeplaylisteleri

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class PlaylisteleriAdapter(oynatmaListeleri: List<PlaylistData.Items>?) :
    RecyclerView.Adapter<PlaylisteleriAdapter.PlaylistViewHolder>() {

    var tumOynatmaListeleri = oynatmaListeleri

    override fun getItemCount(): Int {
        return tumOynatmaListeleri?.size!!
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PlaylistViewHolder {
        var inflater = LayoutInflater.from(p0.context)
        var listItem = inflater.inflate(R.layout.list_item,p0,false)
        return PlaylistViewHolder(listItem)
    }


    override fun onBindViewHolder(p0: PlaylistViewHolder, p1: Int) {
        var oanOlusanSatir = tumOynatmaListeleri?.get(p1)
        p0.setData(oanOlusanSatir,p1)
    }


    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myItemView = itemView as CardView
        var playListTitle = myItemView.textView
        var playListImage = myItemView.imageView

        fun setData(oanOlusanSatir: PlaylistData.Items? , positon : Int) {
            playListTitle.text = oanOlusanSatir?.snippet?.title
        }
    }
}
