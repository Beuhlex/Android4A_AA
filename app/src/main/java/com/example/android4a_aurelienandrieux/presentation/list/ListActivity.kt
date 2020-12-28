package com.example.android4a_aurelienandrieux.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a_aurelienandrieux.R
import org.koin.android.ext.android.inject


class ListActivity : AppCompatActivity() {

    val listViewModel: ListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        showList()
    }

    fun showList(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.setHasFixedSize(true)

//        val layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//
//        val mAdapter = ListAdapter(lozGamesList, this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val input: MutableList<String> = ArrayList()
        for (i in 0..99) {
            input.add("Test$i")
        } // define an adapter

        val mAdapter = ListAdapter(input)
        recyclerView.adapter = mAdapter

    }
}