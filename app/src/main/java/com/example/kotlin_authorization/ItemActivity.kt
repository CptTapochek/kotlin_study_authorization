package com.example.kotlin_authorization

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()
        co.setKeyID("rzp_test_EgmQoGwAT33eJi")

        val title: TextView = findViewById(R.id.item_view_title)
        val text: TextView = findViewById(R.id.item_view_text)
        val price: TextView = findViewById(R.id.item_view_price)
        val images: ImageView = findViewById(R.id.images_view)
        val btnBuy: Button = findViewById(R.id.buy_button)

        val imageId = resources.getIdentifier(
            intent.getStringExtra("itemImage"),
            "drawable",
            packageName
        )
        images.setImageResource(imageId)
        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        price.text = intent.getStringExtra("itemPrice")
        btnBuy.setOnClickListener {
            startPayment()
        }
    }

    private fun startPayment() {
        /*
        *  You need to pass the current activity to let Razorpay create CheckoutActivity
        * */
        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","NXTL")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#f00");
            options.put("currency","USD");
            options.put("order_id", "order_DBJOWzybf0sJbb");
            options.put("amount",10000)

            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}