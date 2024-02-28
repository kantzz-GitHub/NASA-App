package com.example.nasa_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nasa_app.R
import com.example.nasa_app.viewmodel.AsteroidsViewModel

class AsteroidsActivity : AppCompatActivity() {
    private val viewModel = AsteroidsViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asteroids)
        viewModel.fetchAsteroidData()

    }
}