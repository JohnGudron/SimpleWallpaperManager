package org.hyperskill.simplewallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rawUrl = intent.getSerializableExtra("imageUrlList")
        val urlList = if (rawUrl == null) {
            listOf(
                "https://ucarecdn.com/26d28a62-ced1-437c-82b2-faae9cb65920/",
                "https://ucarecdn.com/ce2e77eb-553b-4e4a-82b7-cbd2f6ce0ac4/",
                "https://ucarecdn.com/f4dce147-bf2a-4852-8064-a4bdb766ca4e/",
                "https://ucarecdn.com/8b1c0fbf-3c07-425a-943e-d81219d12440/",
                "https://ucarecdn.com/b8d0e783-afaa-46b5-973d-cd433edf59ef/"
            )
        } else {
            rawUrl as List<String>
        }

        ImageList.urlList.clear()
        ImageList.urlList.addAll(urlList)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, MainFragment(ImageList.urlList))
            addToBackStack(null)
            commit()
        }
    }
}
