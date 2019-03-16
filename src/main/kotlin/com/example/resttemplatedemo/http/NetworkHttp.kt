package com.example.resttemplatedemo.http

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser
import com.example.resttemplatedemo.users.User
import org.springframework.stereotype.Component

interface Http {
    fun get(endpoint: String): List<JSONPlaceholderAPIUser>
}

@Component
class NetworkHttp : Http {
    override fun get(endpoint: String): List<JSONPlaceholderAPIUser> {
        TODO("not implemented")
    }
}
