package org.hyperskill.simplewallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImageAdapter(private val fragmentManager: FragmentManager, private val images: List<String>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
        Picasso.get()
            .load(images[position])
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(imageView)

        holder.itemView.setOnClickListener {
            fragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, WallpaperDetails(images[position]))
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}