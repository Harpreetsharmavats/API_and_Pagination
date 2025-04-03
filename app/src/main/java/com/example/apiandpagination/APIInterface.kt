package com.example.apiandpagination

import com.example.apiandpagination.Modals.RandomApiItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("api/users/random_user")
     suspend fun getUser(
        @Query("size") result: Int = 100,
     ) : Response<List<RandomApiItem>>
companion object{
    private var apiInterface: APIInterface? = null
    private const val BASE_URL = "https://random-data-api.com/"

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