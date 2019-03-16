package com.example.resttemplatedemo.http

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser
import org.springframework.stereotype.Component

interface Http {
    fun get(endpoint: String): JSONPlaceholderAPIUser
}

@Component
class NetworkHttp : Http {
    override fun get(endpoint: String): JSONPlaceholderAPIUser {
        TODO("not implemented")
    }
}
