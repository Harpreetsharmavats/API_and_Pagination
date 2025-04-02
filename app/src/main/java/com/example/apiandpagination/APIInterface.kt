package com.example.apiandpagination

import com.example.apiandpagination.Modals.User
import com.example.apiandpagination.Modals.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("users")
     suspend fun getUser(
        @Query("page") quantity: Int = 500
     ) : Response<List<UserResponse>>
companion object{
    private var apiInterface: APIInterface? = null
    private const val baseUrl = "https://fakerapi.it/"

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