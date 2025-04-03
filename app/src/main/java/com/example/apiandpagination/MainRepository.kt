package com.example.apiandpagination

class MainRepository(private val aPIInterface: APIInterface) {
    suspend fun getUser() = aPIInterface.getUser()
}