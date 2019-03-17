package com.example.resttemplatedemo.http

class SpyHttp<T>(var get_returnValue: ExternalAPIHttpResponse<T?>) : Http<T> {
    var get_argument_endpoint: String? = null
        private set
    var get_argument_responseBodyClassType: Class<T>? = null

    override fun get(endpoint: String, responseBodyClassType: Class<T>): ExternalAPIHttpResponse<T?> {
        get_argument_endpoint = endpoint
        get_argument_responseBodyClassType = responseBodyClassType
        return get_returnValue
    }
}
