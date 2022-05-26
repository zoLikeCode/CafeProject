package com.example.cafeproject.ui

import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cafeproject.R
import com.example.cafeproject.adapters.ViewPagerCustomAdapter
import com.example.cafeproject.databinding.ActivityMainScreenBinding
import com.example.cafeproject.ui.foodmenu.DrinksFragment
import com.example.cafeproject.ui.foodmenu.FoodsFragment
import com.example.cafeproject.ui.foodmenu.SauceFragment
import com.example.cafeproject.ui.foodmenu.SnacksFragment
import com.example.cafeproject.ui.onboarding.FirstScreen
import com.example.cafeproject.ui.onboarding.SecondScreen
import com.google.android.material.tabs.TabLayoutMediator

class MainScreen : FragmentActivity() {
    lateinit var binding: ActivityMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding) {
        val navController = findNavController(R.id.fragmentView)
        bottomNavigationView.setupWithNavController(navController)
    }
}