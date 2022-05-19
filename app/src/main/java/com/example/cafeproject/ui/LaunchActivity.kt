package com.example.cafeproject.ui

import android.content.Context
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.getSystemService
import com.example.cafeproject.databinding.ActivityLaunchBinding

class LaunchScreen : AppCompatActivity() {
    lateinit var binding: ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkInternet()
    }

    fun checkInternet() = with(binding) {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val cp = cm.getNetworkCapabilities(cm.activeNetwork)
        if (cp == null) {
            progressBar.visibility = View.GONE
            return
        }
        if (cp.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            progressBar.visibility =
                View.VISIBLE
            return
        }

        if (cp.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            progressBar.visibility =
                View.VISIBLE
            return
        }
        if (cp.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
            progressBar.visibility =
                View.VISIBLE
            return
        }
        progressBar.visibility = View.GONE
    }


}