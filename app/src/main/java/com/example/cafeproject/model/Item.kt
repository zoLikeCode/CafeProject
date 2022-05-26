package com.example.cafeproject.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("dishId")
    val dishId: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("nameDish")
    val nameDish: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("version")
    val version: String
)