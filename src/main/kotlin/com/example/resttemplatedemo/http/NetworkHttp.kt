package com.example.resttemplatedemo.http

import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

interface Http<T> {
    fun get(endpoint: String, responseBodyClassType: Class<T>): ExternalAPIHttpResponse<T?>
}

@Component
class NetworkHttp<T>(val restTemplate: RestTemplate) : Http<T> {
    override fun get(endpoint: String, responseBodyClassType: Class<T>): ExternalAPIHttpResponse<T?> {
        val responseEntity = restTemplate.exchange<T>(
                endpoint,
                HttpMethod.GET,
                HttpEntity(""),
                responseBodyClassType
        )

        if (responseEntity.statusCode == HttpStatus.BAD_REQUEST) {
            return ExternalAPIHttpResponse.Failure("Bad Request")
        }

        return ExternalAPIHttpResponse.Success(responseEntity.body)
    }
}
