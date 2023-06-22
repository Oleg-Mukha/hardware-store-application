package com.example.hardware_store_app.bindingadapters

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.like.LikeButton

@BindingAdapter("isLikedButton")
fun LikeButton.isLikedButton(value: MutableLiveData<Boolean?>) {
    value.observeForever {
        this.isLiked = it ?: false
    }
}