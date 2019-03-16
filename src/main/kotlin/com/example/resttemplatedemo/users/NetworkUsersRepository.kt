package com.example.resttemplatedemo.users

import com.example.resttemplatedemo.http.Http
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser
import org.springframework.stereotype.Repository

interface UsersRepository {
    fun getAll(): List<User>
}

@Repository
class NetworkUsersRepository(val http: Http<JSONPlaceholderAPIUser>) : UsersRepository {
    override fun getAll(): List<User> {
        val externalHttpResponse = http.get("https://jsonplaceholder.typicode.com/users")

        val apiResponseUser = externalHttpResponse.value

        return listOf(
                User(
                        id = apiResponseUser.id,
                        username = apiResponseUser.username,
                        name = apiResponseUser.name,
                        email = apiResponseUser.emailAddress
                )
        )
    }
}
