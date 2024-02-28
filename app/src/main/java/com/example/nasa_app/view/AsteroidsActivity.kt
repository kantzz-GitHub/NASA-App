package com.example.nasa_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa_app.R
import com.example.nasa_app.adapter.AsteroidAdapter
import com.example.nasa_app.databinding.ActivityAsteroidsBinding
import com.example.nasa_app.viewmodel.AsteroidsViewModel

class AsteroidsActivity : AppCompatActivity() {
    private val viewModel = AsteroidsViewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AsteroidAdapter
    lateinit var binding: ActivityAsteroidsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsteroidsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.asteroidRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AsteroidAdapter(mutableListOf())
        recyclerView.adapter = adapter


        viewModel.fetchAsteroidData()

        viewModel.asteroidData.observe(this) { asteroids ->
            adapter.setData(asteroids.values.flatten())
        }

    }
}