package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.picasso.Adapter.PhotoAdapter
import com.example.picasso.Api.MyApi
import com.example.picasso.Entities.Photo
import com.example.picasso.RetrofitClient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var api: MyApi? = null
    lateinit var lv_photos: ListView
    lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicioApi()
        callGetPhotos()
    }

    private fun callGetPhotos() {
        val callGetPhotos = api?.getPhotos()
        callGetPhotos?.enqueue(object: Callback<List<Photo>>{
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                var photosList: List<Photo>? = response.body()
                lv_photos = findViewById(R.id.lv_photos)
                adapter = PhotoAdapter(photosList!!)
                lv_photos.adapter = adapter
            }

        })
    }

    private fun inicioApi() {
        api = RetrofitClient.retrofit.create(MyApi::class.java)
    }


}
