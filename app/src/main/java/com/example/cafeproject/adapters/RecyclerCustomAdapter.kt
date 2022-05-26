package com.example.cafeproject.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeproject.R
import com.example.cafeproject.databinding.RcItemBinding
import com.example.cafeproject.model.Item
import com.squareup.picasso.Picasso

class RecyclerCustomAdapter :
    RecyclerView.Adapter<RecyclerCustomAdapter.ItemHolder>() {
    val foodList = ArrayList<Item>()

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RcItemBinding.bind(view)
        fun bind(i: Item) = with(binding) {
            Picasso.get().load(i.icon).fit()
                .into(Picture)
            TitleItem.text = i.nameDish
            Price.text = "N${i.price}"
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(foodList[position])
        holder.binding.cardItem.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun addFoodList(items: ArrayList<Item>) {
        foodList.addAll(items)
        notifyDataSetChanged()
    }
}