package com.example.wishlist

import android.graphics.Color
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.List

class ListAdapter (private val items: List<Items>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var x: MutableList<Items> = items as MutableList<Items>
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item: TextView
        val price: TextView
        val link: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // the public final member variables created above
            item = itemView.findViewById(R.id.itemTv)
            price = itemView.findViewById(R.id.priceTv)
            link = itemView.findViewById(R.id.storeLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_items, parent, false)

        // Return a new holder instance
        return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.item.text = item.item
        holder.price.text = item.price.toString()
        holder.link.text = item.link
        
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun deleteItem(index: Int){
        x.removeAt(index)
        notifyDataSetChanged()
    }
}

