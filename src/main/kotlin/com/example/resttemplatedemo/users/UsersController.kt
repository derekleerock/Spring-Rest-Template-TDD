package com.example.resttemplatedemo.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {
    @GetMapping
    fun getAll(): User {
        return User(12, "cdavis", "charlie davis", "cdavis@jmail.com")
    }
}
