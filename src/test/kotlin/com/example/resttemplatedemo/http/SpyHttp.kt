package com.example.resttemplatedemo.http

class SpyHttp : Http {
    var get_argument_endpoint: String? = null
        private set
    override fun get(endpoint: String) {
        get_argument_endpoint = endpoint
    }
}
