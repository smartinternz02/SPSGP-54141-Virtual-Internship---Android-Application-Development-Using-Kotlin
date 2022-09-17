package com.rihanali001.groceryapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), GroceryRVAdapter.GroceryItemClickInterface {
    lateinit var itemRV: RecyclerView
    lateinit var addFAB: FloatingActionButton
    lateinit var list: List<GroceryItems>
    lateinit var groceryRVAdapter: GroceryRVAdapter
    lateinit var groceryViewModel: GroceryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemRV = findViewById(R.id.rvitems)
        addFAB = findViewById(R.id.fabAdd)
        list = ArrayList()
        groceryRVAdapter = GroceryRVAdapter(list,this)
        itemRV.layoutManager = LinearLayoutManager(this)
        itemRV.adapter = groceryRVAdapter
        val groceryRepository = GroceryRepository(GroceryDatabase(this))
        val factory = GroceryViewModelFactory(groceryRepository)
        groceryViewModel = ViewModelProvider(this,factory).get(GroceryViewModel::class.java)
        groceryViewModel.getAllGroceryItems().observe(this, Observer {
            groceryRVAdapter.list = it
            groceryRVAdapter.notifyDataSetChanged()
        })
        addFAB.setOnClickListener{
            openDialog()
        }
    }

    fun openDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.grocery_add_dialog)
        val cancelbtn = dialog.findViewById<AppCompatButton>(R.id.cancel_btn)
        val addbtn = dialog.findViewById<AppCompatButton>(R.id.add_btn)
        val itemEdt = dialog.findViewById<EditText>(R.id.edit_text_item_name)
        val itemPriceEdt = dialog.findViewById<EditText>(R.id.edit_text_item_price)
        val itemQuantityEdt = dialog.findViewById<EditText>(R.id.edit_text_item_quantity)
        cancelbtn.setOnClickListener {
            dialog.dismiss()
        }
        addbtn.setOnClickListener {
            val itemName:String = itemEdt.text.toString()
            val itemPrice:String = itemPriceEdt.text.toString()
            val itemQuantity:String = itemQuantityEdt.text.toString()
            val qty : Double = itemQuantity.toDouble()
            val pr : Double = itemPrice.toDouble()
            if (itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemQuantity.isNotEmpty()){
                val items = GroceryItems(itemName,qty,pr)
                groceryViewModel.insert(items)
                Toast.makeText(applicationContext,"Item Added", Toast.LENGTH_SHORT).show()
                groceryRVAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            else{
                Toast.makeText(applicationContext,"Please fill all details properly", Toast.LENGTH_SHORT).show()
            }

        }
        dialog.show()
    }

    override fun onItemClick(groceryItems: GroceryItems) {
        groceryViewModel.delete(groceryItems)
        groceryRVAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext,"Item Deleted Successfully.",Toast.LENGTH_SHORT).show()
    }
}