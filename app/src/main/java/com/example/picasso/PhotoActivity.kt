package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        var photoBundle = intent.extras

        setViews(photoBundle)

    }

    private fun setViews(photoBundle: Bundle?) {
        var tv_albumId = findViewById<TextView>(R.id.tv_albumid)
        var tv_id = findViewById<TextView>(R.id.tv_id)
        var tv_title = findViewById<TextView>(R.id.tv_title2)
        var iv_photo = findViewById<ImageView>(R.id.iv_photo)

        tv_albumId.setText(photoBundle!!.getString("albumId"))
        tv_id.setText(photoBundle!!.getString("id"))
        tv_title.setText(photoBundle!!.getString("title"))

        Picasso.get().isLoggingEnabled = true
        Picasso
            .get()
            .load(photoBundle!!.getString("url"))
            .into(iv_photo)
    }
}
