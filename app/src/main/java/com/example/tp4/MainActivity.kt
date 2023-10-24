package com.example.tp4

import MyAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: MyAdapter
    private lateinit var addButton: Button
    private var values = arrayListOf<String>("item1", "item2", "item3", "item4", "item5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values, this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = myAdapter

        addButton = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val n = values.size + 1
            values.add("item$n")
            myAdapter.notifyItemInserted(values.size)
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        values[position] = "Clicked"
        myAdapter.notifyItemChanged(position)
    }
}

