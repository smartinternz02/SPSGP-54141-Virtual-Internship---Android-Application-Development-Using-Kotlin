package com.rihanali001.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    private val groceryItemClickInterface: GroceryItemClickInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.item_name_text)
        val quantityTV: TextView = itemView.findViewById(R.id.item_quantity_text)
        val rateTV: TextView = itemView.findViewById(R.id.item_rate_text)
        val totalTV: TextView = itemView.findViewById(R.id.total_amount_text)
        val deleteIV: ImageView = itemView.findViewById(R.id.delete_img)
    }

    interface GroceryItemClickInterface {
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item, parent, false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.apply {
            nameTV.text = list[position].itemName
            quantityTV.text = "x${list[position].itemQuantity}"
            rateTV.text = NumberFormat.getCurrencyInstance().format(list[position].itemPrice)
            val itemTotal: Double = list[position].itemQuantity * list[position].itemPrice
            totalTV.text = NumberFormat.getCurrencyInstance().format(itemTotal)
            deleteIV.setOnClickListener {
                groceryItemClickInterface.onItemClick(list[position])

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}