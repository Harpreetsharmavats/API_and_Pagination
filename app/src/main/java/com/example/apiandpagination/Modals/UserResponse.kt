package com.example.apiandpagination.Modals

data class UserResponse(
    val users: List<User>,
    val page :Int?
)
