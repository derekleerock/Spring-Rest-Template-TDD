package com.example.resttemplatedemo.users

import com.example.resttemplatedemo.http.SpyHttp
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class NetworkUsersRepositoryTest {
    @Test
    fun getAll_hits_the_expected_endpoint() {
        val spyHttp = SpyHttp()
        val usersRepository = NetworkUsersRepository(spyHttp)


        usersRepository.getAll()


        val expectedEndpoint = "https://jsonplaceholder.typicode.com/users"
        assertThat(spyHttp.get_argument_endpoint, equalTo(expectedEndpoint))
    }
}
