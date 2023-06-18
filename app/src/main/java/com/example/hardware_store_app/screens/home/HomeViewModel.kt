package com.example.hardware_store_app.screens.home

import androidx.lifecycle.ViewModel
import com.example.hardware_store_app.R
import com.example.hardware_store_app.data.Advert
import com.example.hardware_store_app.data.Product

class HomeViewModel : ViewModel() {
    val listOfAds = listOf(
        Advert(
            advertName = "Advert caption",
            advertDescription = "Advert description, description",
            advertImage = R.drawable.ic_launcher_foreground
        ),
        Advert(
            advertName = "Advert caption",
            advertDescription = "Advert description, description"
        ),
    )

    val listOfCategories = listOf(
        Product(name = "Construction Materials", image = R.drawable.ic_launcher_foreground),
        Product(name = "Paints and varnishes", image = R.drawable.ic_launcher_foreground),
        Product(name = "Electrical goods", image = R.drawable.ic_launcher_foreground)
    )
}
