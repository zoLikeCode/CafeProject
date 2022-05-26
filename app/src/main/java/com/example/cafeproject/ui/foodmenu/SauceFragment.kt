package com.example.cafeproject.ui.foodmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cafeproject.R
import com.example.cafeproject.databinding.FragmentSauceBinding


class SauceFragment : Fragment() {
    lateinit var binding: FragmentSauceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSauceBinding.inflate(inflater, container, false)
        return binding.root
    }


}