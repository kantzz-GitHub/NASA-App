package com.example.nasa_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa_app.adapter.RoverPhotoAdapter
import com.example.nasa_app.model.RoverPhoto
import com.example.nasa_app.service.APIService
import com.example.nasa_app.viewmodel.MarsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MarsInfoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RoverPhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_info)

        recyclerView = findViewById(R.id.marsInfoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RoverPhotoAdapter(mutableListOf())
        recyclerView.adapter = adapter

        val viewModel = MarsViewModel()

        viewModel.marsData.observe(this, Observer<List<RoverPhoto>> { roverPhotos ->
            adapter.setData(roverPhotos)
        })

        viewModel.fetchMarsInfo(1000, 1,"XHTunl7AhqAt4VGOW5dEWP1AseCzGBN1hL5ToSA0")

    }
}