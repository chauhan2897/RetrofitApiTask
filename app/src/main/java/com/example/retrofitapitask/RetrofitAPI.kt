package com.example.retrofitapitask

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("posts")
    fun getAllData(): Call<DataModel>
}