package com.example.nasa_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.nasa_app.databinding.ActivityMainBinding
import com.example.nasa_app.databinding.ActivityPictureBinding
import com.example.nasa_app.model.RoverPhoto
import com.example.nasa_app.viewmodel.MarsViewModel
import com.example.nasa_app.viewmodel.PicOfTheDayViewModel

class PictureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPictureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPictureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = PicOfTheDayViewModel()

        viewModel.pictureData.observe(this, Observer { picture ->
            binding.tvCopyright.text = picture.copyright
            binding.tvDate.text = picture.date
            binding.tvName.text = picture.title

            Glide.with(this).load(picture.url).into(binding.imageView2)
        })
    }
}