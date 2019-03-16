package com.example.resttemplatedemo.users

class StubUsersRepository : UsersRepository {
    var getAll_returnValue: List<User> = listOf()
    override fun getAll(): List<User> {
        return getAll_returnValue
    }
}
