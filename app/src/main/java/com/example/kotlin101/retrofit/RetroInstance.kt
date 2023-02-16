package com.example.kotlin101.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        private const val Base_URL = "https://restcountries.com/"//v2/

        fun getRetroIntance(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}