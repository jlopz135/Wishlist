package com.example.wishlist

import android.util.Log

class ListFetcher {
    companion object {
        val itemsList = listOf("test","TEST2","three")
        val price = listOf(10, 11,12)
        val link = listOf("google.com", "GOOGLE.COM","yahoo.com")
        fun getItems(): MutableList<Items> {
            val items : MutableList<Items> = ArrayList()
            for (i in 0..2) {
                val item = Items(itemsList[i], price[i], link[i])
                items.add(item)
                Log.v(itemsList[i], itemsList[i])
            }
            return items
        }
        fun addItem(): MutableList<Items> {
            var newItem : MutableList<Items> = ArrayList()
            for (i in itemsList.size until (itemsList.size+newItem.size-1)) {
                val item = Items(itemsList[i], price[i], link[i])
                newItem.add(item)
            }
            return newItem
        }
    }
}