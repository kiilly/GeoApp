package com.example.kotlin101.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin101.R
import com.example.kotlin101.data.CountryModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.*

class CountryListAdapter(private val activity: Activity): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList: List<CountryModel>? = null

    fun setCountryList (countryList: List<CountryModel>?) {
        this.countryList = countryList
    }

    override fun getItemCount(): Int {
        return if (countryList == null) 0
        else countryList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = countryList?.get(position)
        if (country != null) {
            holder.bind(country, activity)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int):CountryListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder( view: View): RecyclerView.ViewHolder(view)
    { private val itemimage = view.findViewById<ImageView>(R.id.item_image)
      private val itemtitle = view.findViewById<TextView>(R.id.item_title)
      private val itemdescription = view.findViewById<TextView>(R.id.item_description)

        fun bind(data: CountryModel, activity: Activity) {
            itemtitle.text = data.name +"(" + data.alpha2Code+")"
            itemdescription.text = "region"+data.region

            val imageUrl = data.flag
            Picasso.get().load(imageUrl).into(itemimage)
        }
    }
}

