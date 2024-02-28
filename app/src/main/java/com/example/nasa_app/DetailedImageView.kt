package com.example.nasa_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.nasa_app.databinding.ActivityDetailedImageViewBinding

class DetailedImageView : AppCompatActivity() {

    lateinit var binding: ActivityDetailedImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Pinch to zoom in and out", Toast.LENGTH_SHORT).show()

        val imageUrl = intent.getStringExtra("image_url")

        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.color.black)
            .error(androidx.appcompat.R.color.error_color_material_dark)
            .into(binding.detailImageView)
    }
}