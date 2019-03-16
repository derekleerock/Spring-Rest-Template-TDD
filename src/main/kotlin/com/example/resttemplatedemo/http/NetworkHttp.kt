package com.example.resttemplatedemo.http

import org.springframework.stereotype.Component

interface Http<T> {
    fun get(endpoint: String): ExternalAPIHttpResponse<T>
}

@Component
class NetworkHttp<T> : Http<T> {
    override fun get(endpoint: String): ExternalAPIHttpResponse<T> {
        TODO("not implemented")
    }
}
