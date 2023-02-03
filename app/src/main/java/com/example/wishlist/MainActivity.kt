package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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


    }
}