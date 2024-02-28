package com.example.nasa_app.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa_app.DetailedImageView
import com.example.nasa_app.R
import com.example.nasa_app.model.NearEarthObject

class AsteroidAdapter(private var asteroids: MutableList<NearEarthObject>) :
    RecyclerView.Adapter<AsteroidAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_marsinfo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val asteroid = asteroids[position]
        Glide.with(holder.itemView.context)
            .load("https://science.nasa.gov/wp-content/uploads/2023/08/psyche-asteroid-illustration-pia24472.jpg")
            .placeholder(R.color.black)
            .error(androidx.appcompat.R.color.error_color_material_dark)
            .into(holder.imageView)

        holder.roverID.text = "Name: ${asteroid.name}"
        holder.textViewEarthDate.text = "Close Approach Date: ${asteroid.close_approach_data[0].closeApproachDateFull}"
        holder.roverName.text = "Max Diameter: ${asteroid.estimated_diameter.kilometers?.estimatedDiameterMax} KM"
        holder.textViewSol.text = "Miss Distance : ${asteroid.close_approach_data[0].missDistance?.kilometers} Km"
        if(asteroid.is_potentially_hazardous_asteroid){
            holder.textViewSol.setTextColor(Color.RED)
        }else{
            holder.textViewSol.setTextColor(Color.GREEN)

        }
        holder.cameraName.text = "Relative Velocity: ${asteroid.close_approach_data[0].relativeVelocity?.kilometersPerHour} KM/h"
        holder.imageView.setOnClickListener {
            val intent = Intent(context, DetailedImageView::class.java)
            intent.putExtra("image_url", "https://science.nasa.gov/wp-content/uploads/2023/08/psyche-asteroid-illustration-pia24472.jpg")
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return asteroids.size
    }
    fun setData(newRoverPhotos: List<NearEarthObject>) {
        asteroids.clear()
        asteroids.addAll(newRoverPhotos)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val roverID: TextView = itemView.findViewById(R.id.roverID)

        val textViewSol: TextView = itemView.findViewById(R.id.textViewSol)
        val textViewEarthDate: TextView = itemView.findViewById(R.id.textViewEarthDate)
        val roverName: TextView = itemView.findViewById(R.id.roverName)
        val cameraName: TextView = itemView.findViewById(R.id.cameraName)
    }
}