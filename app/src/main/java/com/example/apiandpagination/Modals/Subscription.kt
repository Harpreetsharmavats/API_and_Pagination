package com.example.apiandpagination.Modals

data class Subscription(
    val payment_method: String,
    val plan: String,
    val status: String,
    val term: String
)