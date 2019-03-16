package com.example.resttemplatedemo.jsonplaceholderapi

data class JSONPlaceholderAPIUser(
    val id: Long,
    val name: String,
    val username: String,
    val emailAddress: String,
    val address: JSONPlaceholderAPIAddress,
    val phone: String,
    val website: String,
    val company: JSONPlaceholderAPICompany
)
