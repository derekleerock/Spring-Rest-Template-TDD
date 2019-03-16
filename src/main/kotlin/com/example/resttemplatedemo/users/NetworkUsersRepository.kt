package com.example.resttemplatedemo.users

import org.springframework.stereotype.Repository

interface UsersRepository {
    fun getAll(): ArrayList<User>
}

@Repository
class NetworkUsersRepository : UsersRepository {
    override fun getAll(): ArrayList<User> {
        TODO("not implemented")
    }
}
