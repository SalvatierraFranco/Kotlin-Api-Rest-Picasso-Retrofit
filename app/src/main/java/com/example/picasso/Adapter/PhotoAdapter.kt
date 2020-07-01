package com.example.picasso.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.picasso.Entities.Photo
import com.example.picasso.R
import com.squareup.picasso.Picasso

class PhotoAdapter: BaseAdapter {
    var photosList: List<Photo>? = null

    constructor(){ }

    constructor(PhotosList: List<Photo>){
        this.photosList = PhotosList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.item_photos, parent, false)

        var aPhoto = this.photosList!![position]

        var iv_photo = v.findViewById<ImageView>(R.id.iv_miniPhoto)
        var tv_title = v.findViewById<TextView>(R.id.tv_title)

        Picasso.get().isLoggingEnabled = true
        Picasso
            .get()
            .load(aPhoto.thumbnailUrl)
            .into(iv_photo)

        tv_title.setText(aPhoto.title)

        return v
    }

    override fun getItem(position: Int): Any {
        return this.photosList!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return this.photosList!![position].id.toLong()
    }

    override fun getCount(): Int {
        return this.photosList!!.size
    }
}