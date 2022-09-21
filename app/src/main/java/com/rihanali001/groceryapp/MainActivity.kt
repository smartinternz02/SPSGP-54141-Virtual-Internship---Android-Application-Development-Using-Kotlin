package com.rihanali001.groceryapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rihanali001.groceryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GroceryRVAdapter.GroceryItemClickInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: List<GroceryItems>
    private lateinit var groceryRVAdapter: GroceryRVAdapter
    private lateinit var groceryViewModel: GroceryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        groceryRVAdapter = GroceryRVAdapter(list, this)

        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = groceryRVAdapter

        val groceryRepository = GroceryRepository(GroceryDatabase(this))
        val factory = GroceryViewModelFactory(groceryRepository)
        groceryViewModel = ViewModelProvider(this, factory)[GroceryViewModel::class.java]
        groceryViewModel.getAllGroceryItems().observe(this, Observer {
            groceryRVAdapter.list = it
            groceryRVAdapter.notifyDataSetChanged()
        })
        binding.fabAdd.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.grocery_add_dialog)

        dialog.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.add_btn).setOnClickListener {
            val itemName: String =
                dialog.findViewById<EditText>(R.id.edit_text_item_name).text.toString()
            val itemPrice: String =
                dialog.findViewById<EditText>(R.id.edit_text_item_price).text.toString()
            val itemQuantity: String =
                dialog.findViewById<EditText>(R.id.edit_text_item_quantity).text.toString()

            if (itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemQuantity.isNotEmpty()) {
                val items = GroceryItems(itemName, itemQuantity.toDouble(), itemPrice.toDouble())
                groceryViewModel.insert(items)
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_SHORT).show()
                groceryRVAdapter.notifyDataSetChanged()
                dialog.dismiss()
            } else {

                Toast.makeText(
                    dialog.context,
                    "Please fill all details properly",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        dialog.show()
    }

    override fun onItemClick(groceryItems: GroceryItems) {
        val name = groceryItems.itemName
        groceryViewModel.delete(groceryItems)
        groceryRVAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "$name Item Deleted Successfully.", Toast.LENGTH_SHORT).show()
    }
}