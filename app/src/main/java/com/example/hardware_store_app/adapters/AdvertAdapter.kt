package com.example.hardware_store_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hardware_store_app.R
import com.example.hardware_store_app.data.Advert

class AdvertAdapter(private var advertList: List<Advert>) :
    RecyclerView.Adapter<AdvertAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val adCaption: TextView = view.findViewById(R.id.tv_ad_caption)
        val adDescription: TextView = view.findViewById(R.id.tv_ad_description)
        val adImage: ImageView = view.findViewById(R.id.iv_advertising)
        val adButton: TextView = view.findViewById(R.id.tv_ad_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.advertisement_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val advert = advertList[position % advertList.size]
        holder.adCaption.text = advert.advertName
        holder.adDescription.text = advert.advertDescription
        holder.adImage.setImageResource(advert.advertImage ?: 0)
        holder.adButton.text = "More"

        setAnimation(holder.itemView)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    private fun setAnimation(view: View) {
        val animation =
            AnimationUtils.loadAnimation(view.context, R.anim.rv_list_fade)
        view.startAnimation(animation)
    }

}