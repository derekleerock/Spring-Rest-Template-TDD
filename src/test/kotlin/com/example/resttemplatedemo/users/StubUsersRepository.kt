package com.example.resttemplatedemo.users

class StubUsersRepository : UsersRepository {
    var getAll_returnValue: ArrayList<User> = arrayListOf()
    override fun getAll(): ArrayList<User> {
        return getAll_returnValue
    }
}
