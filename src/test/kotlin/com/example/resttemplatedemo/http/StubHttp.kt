package com.example.resttemplatedemo.http

class StubHttp<T>(var get_returnValue: ExternalAPIHttpResponse<T>) : Http<T> {
    override fun get(endpoint: String, responseBodyClassType: Class<T>): ExternalAPIHttpResponse<T> {
        return get_returnValue
    }
}
