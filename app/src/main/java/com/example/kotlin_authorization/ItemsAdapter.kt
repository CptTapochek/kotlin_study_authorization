package com.example.kotlin_authorization

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_view)
        val title: TextView = view.findViewById(R.id.item_title)
        val description: TextView = view.findViewById(R.id.item_description)
        val price: TextView = view.findViewById(R.id.item_price)
        val button: Button = view.findViewById(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.description.text = items[position].about
        holder.price.text = items[position].price.toString() + "$"

        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)

        holder.button.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)
            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemImage", items[position].image)
            intent.putExtra("itemText", items[position].description)
            intent.putExtra("itemPrice", items[position].price.toString() + "$")
            context.startActivity(intent)
        }
    }
}