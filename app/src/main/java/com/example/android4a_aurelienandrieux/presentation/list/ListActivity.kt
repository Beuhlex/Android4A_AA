package com.example.android4a_aurelienandrieux.presentation.list

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a_aurelienandrieux.R
import com.example.android4a_aurelienandrieux.data.local.models.ZeldaGames
import org.koin.android.ext.android.inject


class ListActivity : AppCompatActivity() {

    val listViewModel: ListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listViewModel.makeApiCall()

        listViewModel.apiLiveData.observe(this, Observer {
            when(it){
                is getApiSuccess -> showList(it.lozGamesList)
                getApiFailure -> Toast.makeText(this@ListActivity, "Failure", Toast.LENGTH_SHORT).show()
                getApiError -> Toast.makeText(this@ListActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun showList(lozGamesList: List<ZeldaGames>){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val mAdapter = ListAdapter(lozGamesList)
        recyclerView.adapter = mAdapter

    }
}