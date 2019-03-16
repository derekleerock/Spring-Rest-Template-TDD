package com.example.resttemplatedemo.users

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class UsersControllerTest {
    @Test
    fun getUsers_returnsOk() {
        val mockMvc = MockMvcBuilders
                .standaloneSetup(UsersController())
                .build()

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk)
    }

    @Test
    fun getUsers_returnsUsers() {
        val mockMvc = MockMvcBuilders
                .standaloneSetup(UsersController())
                .build()

        mockMvc.perform(get("/users"))
                .andExpect(jsonPath("$.id", equalTo(12)))
                .andExpect(jsonPath("$.username", equalTo("cdavis")))
                .andExpect(jsonPath("$.name", equalTo("charlie davis")))
                .andExpect(jsonPath("$.email", equalTo("cdavis@jmail.com")))
    }
}