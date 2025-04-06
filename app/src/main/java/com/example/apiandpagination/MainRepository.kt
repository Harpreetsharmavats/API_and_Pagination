package com.example.apiandpagination

import com.example.apiandpagination.Modals.UsersItem
import retrofit2.Response

class MainRepository(private val aPIInterface: APIInterface) {
    suspend fun getUser(page : Int) : Response<List<UsersItem>>{
        return aPIInterface.getUser(page, page)
    }
}