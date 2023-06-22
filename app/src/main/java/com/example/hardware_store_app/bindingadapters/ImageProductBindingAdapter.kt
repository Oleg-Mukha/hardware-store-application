package com.example.hardware_store_app.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImage")
fun ImageView.setImage(image: Int?) {
    this.setImageResource(image ?: 0)
}