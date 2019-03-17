package com.example.resttemplatedemo.http

class ExternalAPIHttpResponse<T> private constructor(val value: T?, val errorMessage: String?) {
    companion object {
        fun <T> Success(value: T): ExternalAPIHttpResponse<T> {
            return ExternalAPIHttpResponse(value, null)
        }

        fun <T> Failure(errorMessage: String): ExternalAPIHttpResponse<T> {
            return ExternalAPIHttpResponse(null, errorMessage)
        }
    }
}
