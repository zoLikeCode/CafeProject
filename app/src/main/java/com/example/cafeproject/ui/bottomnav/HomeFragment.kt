package com.example.cafeproject.ui.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.cafeproject.R
import com.example.cafeproject.adapters.ViewPagerCustomAdapter
import com.example.cafeproject.databinding.FragmentHomeBinding
import com.example.cafeproject.ui.foodmenu.DrinksFragment
import com.example.cafeproject.ui.foodmenu.FoodsFragment
import com.example.cafeproject.ui.foodmenu.SauceFragment
import com.example.cafeproject.ui.foodmenu.SnacksFragment
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewPager: ViewPagerCustomAdapter
    private val titleFragments = listOf("Foods", "Drinks", "Snacks", "Sauce")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewPager = ViewPagerCustomAdapter(requireActivity())
        viewPager.fragments.addAll(
            listOf(
                FoodsFragment(),
                DrinksFragment(),
                SnacksFragment(),
                SauceFragment()
            )
        )
        binding.viewPagerMenu.adapter = viewPager
        init()
        return binding.root
    }

    private fun init() = with(binding) {
        TabLayoutMediator(tabLayout, viewPagerMenu) { tab, position ->
            tab.text = titleFragments[position]
        }.attach()
    }


}