package com.example.wishlist


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
        fun addItemFunc(name:String, price: String, link: String): Items {
            val items = getItems()
            val item = Items(name, price, link)
                //Log.v(item.toString(), item.toString())
            items.add(item)

            return item
        }
    }
}