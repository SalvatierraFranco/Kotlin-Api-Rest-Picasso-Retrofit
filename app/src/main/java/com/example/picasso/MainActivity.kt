package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.picasso.Api.MyApi
import com.example.picasso.RetrofitClient.RetrofitClient

class MainActivity : AppCompatActivity() {

    var api: MyApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicioApi()
    }

    private fun inicioApi() {
        api = RetrofitClient.retrofit.create(MyApi::class.java)
    }
}
