package com.example.apiandpagination

import com.example.apiandpagination.Modals.UsersItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    //https://gorest.co.in/public/v2/users?page=1&per_page=100
    @GET("users")
     suspend fun getUser(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int =100
     ) : Response<List<UsersItem>>
companion object{
    private var apiInterface: APIInterface? = null
    private const val BASE_URL = "https://gorest.co.in/public/v2/"

    fun getInstance(): APIInterface {
        if (apiInterface == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiInterface = retrofit.create(APIInterface::class.java)
        }
        return apiInterface!!
    }
}
}