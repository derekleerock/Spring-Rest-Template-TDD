package com.example.resttemplatedemo.users

import com.example.resttemplatedemo.http.Http
import org.springframework.stereotype.Repository

interface UsersRepository {
    fun getAll(): ArrayList<User>
}

@Repository
class NetworkUsersRepository(val http: Http) : UsersRepository {
    override fun getAll(): ArrayList<User> {
        http.get("https://jsonplaceholder.typicode.com/users")
        return arrayListOf()
    }
}
