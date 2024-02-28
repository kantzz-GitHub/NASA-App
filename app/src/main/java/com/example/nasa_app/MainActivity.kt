package com.example.nasa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nasa_app.databinding.ActivityMainBinding
import com.example.nasa_app.view.AsteroidsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
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



    }
}