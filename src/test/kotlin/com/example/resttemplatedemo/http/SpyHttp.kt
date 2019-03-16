package com.example.resttemplatedemo.http

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser

class SpyHttp : Http {
    var get_argument_endpoint: String? = null
        private set

    override fun get(endpoint: String): List<JSONPlaceholderAPIUser> {
        get_argument_endpoint = endpoint
        return listOf()
    }
}
