package com.example.nasa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nasa_app.databinding.ActivityMainBinding
import com.example.nasa_app.view.AsteroidsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launchActivityButton = findViewById<Button>(R.id.btn_launch_marsRoverInfoActivity)
        launchActivityButton.setOnClickListener {
            startActivity(Intent(this, MarsInfoActivity::class.java))
        }

        val asteriodBtn = findViewById<Button>(R.id.button)
        asteriodBtn.setOnClickListener {
            startActivity(Intent(this, AsteroidsActivity::class.java))
        }

        val pictureOfTheDayBtn = findViewById<Button>(R.id.pictureOfTheDayBtn)
        pictureOfTheDayBtn.setOnClickListener {
            startActivity(Intent(this, PictureActivity::class.java))
        }

        val aboutBtn = findViewById<Button>(R.id.about)
        aboutBtn.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}