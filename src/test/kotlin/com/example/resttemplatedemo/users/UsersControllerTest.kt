package com.example.resttemplatedemo.users

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class UsersControllerTest {
    private lateinit var mockMvc: MockMvc
    private lateinit var stubUsersRepo: StubUsersRepository

    @Before
    fun setUp() {
        stubUsersRepo = StubUsersRepository()
        val usersController = UsersController(stubUsersRepo)
        mockMvc = MockMvcBuilders
                .standaloneSetup(usersController)
                .build()
    }

    @Test
    fun getUsers_returnsOk() {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk)
    }

    @Test
    fun getUsers_returnsUsers() {
        stubUsersRepo.getAll_returnValue = listOf(
                User(12, "cdavis", "charlie davis", "cdavis@jmail.com")
        )

        mockMvc.perform(get("/users"))
                .andExpect(jsonPath("$[0].id", equalTo(12)))
                .andExpect(jsonPath("$[0].username", equalTo("cdavis")))
                .andExpect(jsonPath("$[0].name", equalTo("charlie davis")))
                .andExpect(jsonPath("$[0].email", equalTo("cdavis@jmail.com")))
    }
}
