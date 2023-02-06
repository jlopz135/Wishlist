package com.example.wishlist


class ListFetcher {
    companion object {
        val itemsList = listOf<String>()
        val price = listOf<String>()
        val link = listOf<String>()
        fun getItems(): MutableList<Items> {
            val items : MutableList<Items> = ArrayList()
            for (i in itemsList.indices) {
                val item = Items(itemsList[i], price[i], link[i])
                items.add(item)
            }

            return items
        }
        fun addItemFunc(name:String, price: String, link: String): Items {
            val items = getItems()
            val item = Items(name, price, link)

            items.add(item)

            return item
        }


    }
}