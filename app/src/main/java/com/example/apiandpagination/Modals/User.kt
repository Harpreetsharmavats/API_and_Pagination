package com.example.apiandpagination.Modals

data class User(
    val id: String? = null,
    val name: String? = null
)
data class UserResponse(
    val users: List<User>,
    val nextPage: Int?
)
