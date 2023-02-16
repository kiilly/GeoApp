package com.example.kotlin101.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin101.data.CountryModel
import com.example.kotlin101.retrofit.RetroInstance
import com.example.kotlin101.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    var liveDataList: MutableLiveData<List<CountryModel>?> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<CountryModel>?> {
        return liveDataList
    }
    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroIntance()
        val retroService =retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getCountryList()
        call.enqueue(object : Callback<List<CountryModel>> {
            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                liveDataList.postValue(response.body())
                println(response.body())
            }
        })
    }
}