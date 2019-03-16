package com.example.resttemplatedemo.http

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser

class StubHttp : Http {
    var get_returnValue: List<JSONPlaceholderAPIUser> = listOf()

    override fun get(endpoint: String): List<JSONPlaceholderAPIUser> {
        return get_returnValue
    }
}
