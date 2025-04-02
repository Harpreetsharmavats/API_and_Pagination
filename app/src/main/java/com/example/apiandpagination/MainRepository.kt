package com.example.apiandpagination

class MainRepository(private val APIInterface: APIInterface) {
    suspend fun getUser(page: Int) = APIInterface.getUser(page)
}