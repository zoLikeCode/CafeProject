package com.example.cafeproject.ui.foodmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cafeproject.R
import com.example.cafeproject.databinding.FragmentDrinksBinding

class DrinksFragment : Fragment() {
    lateinit var binding: FragmentDrinksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }
}