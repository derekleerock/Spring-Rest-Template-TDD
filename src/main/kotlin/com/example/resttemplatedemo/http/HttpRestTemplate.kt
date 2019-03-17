package com.example.resttemplatedemo.http

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class HttpRestTemplate {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}
