package com.example.resttemplatedemo.jsonplaceholderapi

data class JSONPlaceholderAPIAddress(
        val street: String,
        val suite: String,
        val city: String,
        val zipcode: String,
        val geo: JSONPlaceholderAPIGeo
)
