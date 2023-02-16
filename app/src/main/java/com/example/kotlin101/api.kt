package com.ndroid.weatherapp2


import androidx.appcompat.app.AppCompatActivity

    lateinit var tvResponse: TextView
class MainActivity1 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResponse = findViewById(R.id.tvResponse)
        // Call the API.
    }

}