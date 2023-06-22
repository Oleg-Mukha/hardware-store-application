package com.example.hardware_store_app

import com.example.hardware_store_app.db.data.Goods

interface ActionHandler {
    fun onCategoryClick(category: String)
}

interface OnItemClick {
    fun onItemClick(id: String)
}
