package com.example.kotlin_authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>()

        items.add(Item(
                1,
                "sofa",
                "Sofa",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Id diam maecenas ultricies mi eget. Suspendisse ultrices gravida dictum fusce. Ultrices sagittis orci a scelerisque purus. Tristique nulla aliquet enim tortor. Enim eu turpis egestas pretium aenean pharetra magna. Nullam non nisi est sit amet facilisis magna etiam tempor. Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus. Urna nec tincidunt praesent semper feugiat. ",
                620
            ))
        items.add(Item(
            2,
            "chair",
            "Chair",
            "Sit amet consectetur adipiscing elit duis tristique sollicitudin. Vel turpis nunc eget lorem dolor sed viverra ipsum.",
            "Consectetur purus ut faucibus pulvinar. Nisl tincidunt eget nullam non nisi. Ultrices eros in cursus turpis massa tincidunt dui. Mi sit amet mauris commodo quis. Consequat id porta nibh venenatis cras sed. Euismod elementum nisi quis eleifend quam adipiscing vitae. Urna molestie at elementum eu facilisis sed. Suspendisse ultrices gravida dictum fusce. Sem viverra aliquet eget sit. Augue lacus viverra vitae congue eu consequat ac felis. Nibh sit amet commodo nulla facilisi nullam vehicula.",
            124
        ))
        items.add(Item(
            3,
            "cabinet",
            "Cabinet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Id diam maecenas ultricies mi eget. Suspendisse ultrices gravida dictum fusce. Ultrices sagittis orci a scelerisque purus. Tristique nulla aliquet enim tortor. Enim eu turpis egestas pretium aenean pharetra magna. Nullam non nisi est sit amet facilisis magna etiam tempor. Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus. Urna nec tincidunt praesent semper feugiat. ",
            849
        ))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}