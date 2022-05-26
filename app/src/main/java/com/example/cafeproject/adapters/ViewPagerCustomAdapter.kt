package com.example.cafeproject.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cafeproject.ui.onboarding.FirstScreen
import com.example.cafeproject.ui.onboarding.SecondScreen

class ViewPagerCustomAdapter(
    fragment: FragmentActivity
) : FragmentStateAdapter(fragment) {
    var fragments = ArrayList<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = fragments[position]
        return fragment
    }


}