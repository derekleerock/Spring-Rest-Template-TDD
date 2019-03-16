package com.example.resttemplatedemo.http

class SpyHttp<T>(var get_returnValue: T) : Http<T> {
    var get_argument_endpoint: String? = null
        private set

    override fun get(endpoint: String): T {
        get_argument_endpoint = endpoint
        return get_returnValue
    }
}
