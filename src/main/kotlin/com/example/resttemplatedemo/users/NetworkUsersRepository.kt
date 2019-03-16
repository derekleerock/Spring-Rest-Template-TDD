package com.example.resttemplatedemo.users

import com.example.resttemplatedemo.http.Http
import org.springframework.stereotype.Repository

interface UsersRepository {
    fun getAll(): List<User>
}

@Repository
class NetworkUsersRepository(val http: Http) : UsersRepository {
    override fun getAll(): List<User> {
        val apiResponseUsers = http.get("https://jsonplaceholder.typicode.com/users")

        return apiResponseUsers.map { apiResponseUser ->
            User(
                    id = apiResponseUser.id,
                    username = apiResponseUser.username,
                    name = apiResponseUser.name,
                    email = apiResponseUser.emailAddress
            )
        }
    }
}
