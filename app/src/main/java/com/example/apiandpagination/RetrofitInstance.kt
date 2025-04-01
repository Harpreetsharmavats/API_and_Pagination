package com.example.apiandpagination

import com.example.apiandpagination.Modals.APIInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://randomuser.me/api/"
    fun getInstance(): APIInterface =

        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(APIInterface::class.java)



}