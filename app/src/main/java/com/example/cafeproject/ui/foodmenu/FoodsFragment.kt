package com.example.cafeproject.ui.foodmenu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import retrofit2.Callback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cafeproject.R
import com.example.cafeproject.adapters.RecyclerCustomAdapter
import com.example.cafeproject.api.RequestApiService
import com.example.cafeproject.databinding.FragmentFoodBinding
import com.example.cafeproject.model.Item
import retrofit2.Call
import retrofit2.Response


class FoodsFragment : Fragment() {
    lateinit var binding: FragmentFoodBinding
    lateinit var adapter: RecyclerCustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        adapter = RecyclerCustomAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this.activity, 2)
        binding.recyclerView.adapter = adapter
        init()
        return binding.root
    }

    fun init() = with(binding) {
        val query = RequestApiService.create()
        query.dishes("1.01").enqueue(object : Callback<ArrayList<Item>> {
            override fun onResponse(
                call: Call<ArrayList<Item>>,
                response: Response<ArrayList<Item>>
            ) {
                if (response.isSuccessful) {
                    adapter.addFoodList(
                        response.body()!!.filter { i -> i.category == "Foods" } as ArrayList<Item>)
                }
            }

            override fun onFailure(call: Call<ArrayList<Item>>, t: Throwable) {
                Log.d("Retrofit", t.message!!)
            }

        })
    }
}