package com.example.apiandpagination

import com.example.apiandpagination.Modals.APIInterface
import retrofit2.Retrofit

class MainRepository constructor(private val APIInterface: APIInterface) {
    suspend fun getUser() = APIInterface.getUser()
}