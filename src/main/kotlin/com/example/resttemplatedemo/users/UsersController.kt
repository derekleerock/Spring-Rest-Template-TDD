package com.example.resttemplatedemo.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController(val usersRepo: UsersRepository) {
    @GetMapping
    fun getAll(): List<User> {
        return usersRepo.getAll()
    }
}
