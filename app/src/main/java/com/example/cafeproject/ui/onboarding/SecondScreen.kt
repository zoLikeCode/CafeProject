package com.example.cafeproject.ui.onboarding

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cafeproject.R
import com.example.cafeproject.databinding.FragmentSecondScreenBinding
import com.example.cafeproject.ui.MainScreen
import com.example.cafeproject.ui.SignInScreen
import com.example.cafeproject.ui.SignUpScreen


class SecondScreen : Fragment() {
    lateinit var binding: FragmentSecondScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        init()
        checkInternet()
        return binding.root
    }

    private fun init() = with(binding) {
        signIn.setOnClickListener {
            val intent = Intent(activity, SignInScreen::class.java)
            startActivity(intent)
        }

        signUp.setOnClickListener {
            val intent = Intent(activity, SignUpScreen::class.java)
            startActivity(intent)
        }

        skipAuth.setOnClickListener {
            val intent = Intent(activity, MainScreen::class.java)
            startActivity(intent)
        }
    }

    fun checkInternet() = with(binding) {
        val cm =
            context?.getSystemService(android.content.Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val cp = cm.getNetworkCapabilities(cm.activeNetwork)
        if (cp == null) {
            skipAuth.visibility = android.view.View.VISIBLE
            return
        }
        if (cp.hasTransport(android.net.NetworkCapabilities.TRANSPORT_WIFI)) {
            skipAuth.visibility =
                android.view.View.GONE
            return
        }

        if (cp.hasTransport(android.net.NetworkCapabilities.TRANSPORT_CELLULAR)) {
            skipAuth.visibility =
                android.view.View.GONE
            return
        }
        if (cp.hasTransport(android.net.NetworkCapabilities.TRANSPORT_ETHERNET)) {
            skipAuth.visibility =
                android.view.View.GONE
            return
        }
        skipAuth.visibility = android.view.View.VISIBLE
    }
}