package com.example.wishlist

import android.util.Log

class ListFetcher {
    companion object {
        val itemsList = listOf("test","TEST2","three")
        val price = listOf("10", "11","12")
        val link = listOf("google.com", "GOOGLE.COM","yahoo.com")
        fun getItems(): MutableList<Items> {
            val items : MutableList<Items> = ArrayList()
            for (i in itemsList.indices) {
                val item = Items(itemsList[i], price[i], link[i])
                items.add(item)
            }
            return items
        }
        fun addItemFunc(name:String, price: String, link: String): MutableList<Items> {
            val newItem : MutableList<Items> = ArrayList()
            for (i in itemsList.size-1 until itemsList.size+newItem.size-1) {
                val item = Items(name, price, link)
                //Log.v(item.toString(), item.toString())
                newItem.add(item)
            }
            return newItem
        }
    }
}