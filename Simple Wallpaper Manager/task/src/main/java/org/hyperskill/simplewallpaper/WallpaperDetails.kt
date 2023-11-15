package org.hyperskill.simplewallpaper

import android.app.WallpaperManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso


class WallpaperDetails(private val imageUrl: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallpaper_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.wallpaperImageView)
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(imageView)

        val bothBtn = view.findViewById<ImageButton>(R.id.lockAndMainScreenSetBtn)
        val screenBtn = view.findViewById<ImageButton>(R.id.screenSetBtn)
        val lockScreenBtn = view.findViewById<ImageButton>(R.id.lockScreenSetBtn)

        val wallpaperManager = WallpaperManager.getInstance(requireContext())
        bothBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallpaperManager.setBitmap(
                    imageView.drawable.toBitmap(),
                    null,
                    false,
                    WallpaperManager.FLAG_SYSTEM
                )
                wallpaperManager.setBitmap(
                    imageView.drawable.toBitmap(),
                    null,
                    false,
                    WallpaperManager.FLAG_LOCK
                )
            }
        }
        screenBtn.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallpaperManager.setBitmap(
                    imageView.drawable.toBitmap(),
                    null,
                    false,
                    WallpaperManager.FLAG_SYSTEM
                )
            }

        }
        lockScreenBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallpaperManager.setBitmap(
                    imageView.drawable.toBitmap(),
                    null,
                    false,
                    WallpaperManager.FLAG_LOCK
                )
            }
        }
    }
}