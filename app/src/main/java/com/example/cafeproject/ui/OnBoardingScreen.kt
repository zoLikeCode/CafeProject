package com.example.cafeproject.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cafeproject.R
import com.example.cafeproject.adapters.ViewPagerCustomAdapter
import com.example.cafeproject.databinding.ActivityLaunchBinding
import com.example.cafeproject.databinding.ActivityOnBoardingScreenBinding
import com.example.cafeproject.ui.onboarding.FirstScreen
import com.example.cafeproject.ui.onboarding.SecondScreen

class OnBoardingScreen : FragmentActivity() {
    lateinit var binding: ActivityOnBoardingScreenBinding
    lateinit var adapterViewPager: ViewPagerCustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterViewPager = ViewPagerCustomAdapter(this)
        adapterViewPager.fragments.addAll(listOf(FirstScreen(), SecondScreen()))
        binding.viewPagerAuth.adapter = adapterViewPager
    }

    override fun onBackPressed() {
        return
    }
}