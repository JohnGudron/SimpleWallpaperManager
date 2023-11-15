package org.hyperskill.simplewallpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment(private val imageList: List<String>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ImageAdapter(parentFragmentManager,  imageList)
        recyclerView.layoutManager = GridLayoutManager(context,2)

        if ((recyclerView.adapter as RecyclerView.Adapter<ImageAdapter.ImageViewHolder>).itemCount <= 0) {
            recyclerView.visibility = View.GONE
            view.findViewById<TextView>(R.id.emptyListTv).visibility = View.VISIBLE
        }
    }

}