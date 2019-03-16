package com.example.resttemplatedemo.http

import org.springframework.stereotype.Component

interface Http {
    fun get(endpoint: String)
}

@Component
class NetworkHttp : Http {
    override fun get(endpoint: String) {
    }
}
