package com.example.picasso.Api

import com.example.picasso.Entities.Photo
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("/albums/1/photos")
    fun getPhotos(): Call<List<Photo>>
}