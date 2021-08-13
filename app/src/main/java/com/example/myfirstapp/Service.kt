package com.example.myfirstapp

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("daily_json.js")
    fun getPrice(): Single<PriceResponse>
}
