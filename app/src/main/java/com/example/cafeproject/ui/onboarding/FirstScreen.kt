package com.example.cafeproject.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cafeproject.R
import com.example.cafeproject.databinding.FragmentFirstScreenBinding
import com.example.cafeproject.databinding.FragmentSecondScreenBinding


class FirstScreen : Fragment() {
    lateinit var binding: FragmentFirstScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}