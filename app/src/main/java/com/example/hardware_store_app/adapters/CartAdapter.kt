package com.example.hardware_store_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.db.data.Cart

class CartAdapter(
    private var cartList: MutableList<Cart>,
    private val onItemClick: OnItemClick?
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.img_product)
        val productName: TextView = view.findViewById(R.id.tv_cart_name)
        val productCategory: TextView = view.findViewById(R.id.tv_cart_category)
        val productPrice: TextView = view.findViewById(R.id.tv_total_price)
        val ellipsis: ImageView = view.findViewById(R.id.iv_ellipsis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cartList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = cartList[position]
        holder.productImage.setImageResource(cartItem.image ?: 0)
        holder.productName.text = cartItem.name
        holder.productCategory.text = cartItem.category
        holder.productPrice.text = "₴${"%.2f".format(cartItem.price)}"

        holder.ellipsis.setOnClickListener {
            onItemClick?.onItemClick(cartItem.productId.toString())
            cartList.remove(cartItem)
            notifyItemRemoved(position)
        }

        setAnimation(holder.itemView)
    }

    private fun setAnimation(view: View) {
        val animation =
            AnimationUtils.loadAnimation(view.context, R.anim.rv_list_fade)
        view.startAnimation(animation)
    }

    fun updateList(list: MutableList<Cart>) {
        cartList = list
        notifyDataSetChanged()
    }
}