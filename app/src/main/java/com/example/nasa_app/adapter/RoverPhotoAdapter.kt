package com.example.nasa_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa_app.R
import com.example.nasa_app.model.RoverPhoto


class RoverPhotoAdapter(private var roverPhotos: MutableList<RoverPhoto>) :
    RecyclerView.Adapter<RoverPhotoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_marsinfo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val roverPhoto = roverPhotos[position]
        Glide.with(holder.itemView.context)
            .load(roverPhoto.imgSrc)
            .placeholder(R.color.white)
            .error(R.color.black)
            .into(holder.imageView)

        holder.textViewSol.text = "Sol: ${roverPhoto.sol}"
        holder.textViewEarthDate.text = "Earth Date: ${roverPhoto.earthDate}"
        holder.roverName.text = "Rover Name: ${roverPhoto.rover.name}"
        holder.roverID.text = "Rover Id: ${roverPhoto.id}"
        holder.cameraName.text = "Rover Id: ${roverPhoto.camera.fullName}"

    }

    override fun getItemCount(): Int {
        return roverPhotos.size
    }
    fun setData(newRoverPhotos: List<RoverPhoto>) {
        roverPhotos.clear()
        roverPhotos.addAll(newRoverPhotos)
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