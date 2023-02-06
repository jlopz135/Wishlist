package com.example.wishlist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.ListFetcher.Companion.addItemFunc
import com.example.wishlist.ListFetcher.Companion.getItems

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv = findViewById<RecyclerView>(R.id.listRv)

        val items = getItems()
        val adapter = ListAdapter(items)

        itemsRv.adapter = adapter

        itemsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.submitBtn).setOnClickListener {
            val name = findViewById<EditText>(R.id.itemName)
            val price = findViewById<EditText>(R.id.price)
            val link2 = findViewById<EditText>(R.id.store)

            val nameText = name.text.toString()
            val priceText = price.text.toString()
            val linkText = link2.text.toString()

            name.hideKeyboard()

            val add = addItemFunc(nameText, priceText, linkText)
            items.add(add)

            Toast.makeText(this, "Item Added to List!", Toast.LENGTH_SHORT).show()


            name.text.clear()
            price.text.clear()
            link2.text.clear()
            name.hint = "Item Name"
            price.hint = "Ex: 10.99"
            link2.hint = "Ex: www.google.com"

            adapter.notifyDataSetChanged()

        }

        itemsRv.setOnClickListener {
            Toast.makeText(this, "Item Number: $adapter", Toast.LENGTH_SHORT).show()

        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}