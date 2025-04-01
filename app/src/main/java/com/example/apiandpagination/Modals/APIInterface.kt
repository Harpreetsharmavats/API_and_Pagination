package com.example.apiandpagination.Modals

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("users")
     suspend fun getUser() : Call<User>

}