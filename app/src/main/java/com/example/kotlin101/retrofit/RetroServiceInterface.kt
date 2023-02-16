package com.example.kotlin101.retrofit

import com.example.kotlin101.data.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("v2/all")
    fun getCountryList(): Call<List<CountryModel>>
}