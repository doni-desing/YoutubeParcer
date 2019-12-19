package com.example.youtubeparcer.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeparcer.R
import com.example.youtubeparcer.model.ItemsItem
import com.squareup.picasso.Picasso

/**
 * Created by Karukes Sergey on
 */
class YouTubeViewHolder(itemView: View, val function: (ItemsItem) -> Any) : RecyclerView.ViewHolder(itemView) {

    private var image: ImageView? = null
    private var title: TextView? = null
    private var description: TextView? = null

    init {
        image = itemView.findViewById(R.id.image)
        title = itemView.findViewById(R.id.title)
        description = itemView.findViewById(R.id.description)
    }

    fun bind(item: ItemsItem) {
        Picasso
            .get()
            .load(item.snippet?.thumbnails?.default?.url)
            .centerCrop()
            .fit()
            .into(image)
        title?.text = item.snippet.channelId
        description?.text = item.contentDetails.itemCount
        itemView.setOnClickListener{
            function(item)
        }
    }

}