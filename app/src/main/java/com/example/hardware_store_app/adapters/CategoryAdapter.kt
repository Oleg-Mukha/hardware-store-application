package com.example.hardware_store_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hardware_store_app.ActionHandler
import com.example.hardware_store_app.R
import com.example.hardware_store_app.data.Product
import com.example.hardware_store_app.databinding.CategoryCardBinding

class CategoryAdapter(private var categoryList: List<Product>, val actionHandler: ActionHandler) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryCard: ConstraintLayout = view.findViewById(R.id.cl_category_card)
        val categoryImage: ImageView = view.findViewById(R.id.iv_category)
        val categoryName: TextView = view.findViewById(R.id.tv_category)
        fun getCategory(): String = categoryName.text.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        val holder = ViewHolder(view)

        holder.categoryCard.setOnClickListener {
            actionHandler.onCategoryClick(holder.getCategory())
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryImage.setImageResource(category.image ?: 0)
        holder.categoryName.text = category.name
    }

    override fun getItemCount(): Int = categoryList.size
}