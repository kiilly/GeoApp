package com.example.kotlin101

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CountryService {
    @GET("data")
    suspend fun getData(): Response<Data>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://restcountries.com/v3.1/all")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

val service = retrofit.create(CountryService::class.java)

suspend fun main() {
    val response = service.getData()
    println(response.body())
}
