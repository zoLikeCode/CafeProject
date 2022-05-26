package com.example.cafeproject.api

import com.example.cafeproject.model.Auth
import com.example.cafeproject.model.Item
import com.example.cafeproject.model.Token
import com.example.cafeproject.model.User
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RequestApiService {

    @Headers("Content-Type: application/json")
    @POST("auth/register")
    fun registration(@Body user: User): Call<String>

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun login(@Body auth: Auth): Call<Token>

    @Headers("Content-Type: application/json")
    @GET("dishes")
    fun dishes(@Query("version") v: String): Call<ArrayList<Item>>

    companion object {
        fun create(): RequestApiService {
            val gson = GsonBuilder().setLenient().create()
            val retrofit =
                Retrofit.Builder()
                    .baseUrl("https://food.madskill.ru/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            return retrofit.create(RequestApiService::class.java)
        }

    }
}