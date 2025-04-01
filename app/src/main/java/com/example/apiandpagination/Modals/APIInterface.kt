package com.example.apiandpagination.Modals

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIInterface {
    @GET("users")
     suspend fun getUser() : Response<List<User>>
companion object{
    private var apiInterface: APIInterface? = null
    private const val baseUrl = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): APIInterface {
        if (apiInterface == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiInterface = retrofit.create(APIInterface::class.java)
        }
        return apiInterface!!
    }
}
}