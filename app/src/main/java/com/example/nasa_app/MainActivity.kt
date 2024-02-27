package com.example.nasa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launchActivityButton = findViewById<Button>(R.id.btn_launch_marsRoverInfoActivity)
        launchActivityButton.setOnClickListener {
            startActivity(Intent(this, MarsInfoActivity::class.java))
        }




    }
}