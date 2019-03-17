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
        val externalHttpResponse = http.get(
                "https://jsonplaceholder.typicode.com/users/8",
                JSONPlaceholderAPIUser::class.java
        )

        val maybeApiResponseUser = externalHttpResponse.value

        maybeApiResponseUser?.let {
            return listOf(
                    User(
                            id = it.id,
                            username = it.username,
                            name = it.name,
                            email = it.email
                    )
            )
        }

        return listOf()
    }
}
