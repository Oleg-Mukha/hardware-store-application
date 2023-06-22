package com.example.hardware_store_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.db.data.Goods

class ProductAdapter(
    private var productList: List<Goods>,
    private val onItemClick: OnItemClick?
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.iv_product_img)
        val productName: TextView = view.findViewById(R.id.tv_product_name)
        val productCategory: TextView = view.findViewById(R.id.tv_product_category)
        val productPrice: TextView = view.findViewById(R.id.tv_product_price)
        var productId: Int? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.productImage.setImageResource(product.image ?: 0)
        holder.productName.text = product.name
        holder.productCategory.text = product.category
        holder.productPrice.text = "${product.price} ₴"
        holder.productId = product.id

        holder.itemView.setOnClickListener {
            onItemClick?.onItemClick(product.id.toString())
        }
    }

    override fun getItemCount(): Int = productList.size

    fun updateList(updatedList: List<Goods>) {
        productList = updatedList
        notifyDataSetChanged()
    }
}