package com.rihanali001.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    private val groceryItemClickInterface: GroceryItemClickInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.idtvitemname)
        val quantityTV: TextView = itemView.findViewById(R.id.idtvquantity)
        val rateTV: TextView = itemView.findViewById(R.id.idtvrate)
        val totalTV: TextView = itemView.findViewById(R.id.idtvtotalamount)
        val deleteIV: ImageView = itemView.findViewById(R.id.idivdelete)
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
        holder.nameTV.text = list[position].itemName
        holder.quantityTV.text = list[position].itemQuantity.toString()
        holder.rateTV.text = "₹: " + list[position].itemPrice.toString()
        val itemTotal: Double = list[position].itemQuantity * list[position].itemPrice
        holder.totalTV.text = "₹: " + itemTotal.toString()
        holder.deleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list[position])

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}