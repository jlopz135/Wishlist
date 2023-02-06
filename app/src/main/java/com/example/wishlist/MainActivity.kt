package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.ListFetcher.Companion.addItemFunc

class MainActivity : AppCompatActivity() {
    lateinit var items: List<Items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv = findViewById<RecyclerView>(R.id.listRv)

        val items = ListFetcher.getItems()
        val adapter = ListAdapter(items)

        itemsRv.adapter = adapter

        itemsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.submitBtn).setOnClickListener{
            val name = findViewById<EditText>(R.id.itemName)
            val price = findViewById<EditText>(R.id.price)
            val link = findViewById<EditText>(R.id.store)

            val nameText = name.text.toString()
            val priceText = price.text.toString()
            val linkText = link.text.toString()

            val add = addItemFunc(nameText, priceText, linkText)
            items.addAll(add)
            Log.v(nameText, nameText)
            Toast.makeText(this, (nameText+priceText+linkText), Toast.LENGTH_SHORT).show()

            adapter.notifyDataSetChanged()

        }

    }
}