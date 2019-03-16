package com.example.resttemplatedemo.http

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser

class StubHttp : Http {
    lateinit var get_returnValue: JSONPlaceholderAPIUser
    override fun get(endpoint: String): JSONPlaceholderAPIUser {
        return get_returnValue
    }
}
