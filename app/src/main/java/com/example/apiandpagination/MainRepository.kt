package com.example.apiandpagination

import com.example.apiandpagination.Modals.APIInterface

class MainRepository(private val APIInterface: APIInterface) {
    suspend fun getUser() = APIInterface.getUser(

    )
}