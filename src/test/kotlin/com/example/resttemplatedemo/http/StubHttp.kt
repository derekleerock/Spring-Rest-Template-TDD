package com.example.resttemplatedemo.http

class StubHttp<T>(var get_returnValue: T) : Http<T> {
    override fun get(endpoint: String): T {
        return get_returnValue
    }
}
