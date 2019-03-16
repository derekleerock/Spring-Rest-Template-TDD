package com.example.resttemplatedemo.users

import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
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
}