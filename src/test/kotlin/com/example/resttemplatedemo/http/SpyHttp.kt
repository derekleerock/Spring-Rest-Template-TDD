package com.example.resttemplatedemo.http

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIAddress
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPICompany
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIGeo
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser

class SpyHttp : Http {
    var get_argument_endpoint: String? = null
        private set

    override fun get(endpoint: String): JSONPlaceholderAPIUser {
        get_argument_endpoint = endpoint
        return JSONPlaceholderAPIUser(
                id = -1,
                name = "",
                username = "",
                emailAddress = "",
                address = JSONPlaceholderAPIAddress(
                        street = "",
                        suite = "",
                        city = "",
                        zipcode = "",
                        geo = JSONPlaceholderAPIGeo(lat = "", lng = "")
                ),
                phone = "",
                website = "",
                company = JSONPlaceholderAPICompany(
                        name = "",
                        catchPhrase = "",
                        bs = ""
                )
        )
    }
}
