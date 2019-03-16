package com.example.resttemplatedemo.users

import com.example.resttemplatedemo.http.SpyHttp
import com.example.resttemplatedemo.http.StubHttp
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIAddress
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPICompany
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIGeo
import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPIUser
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

    @Test
    fun getAll_returnsUsers() {
        val stubHttp = StubHttp()
        val usersRepository = NetworkUsersRepository(stubHttp)


        stubHttp.get_returnValue = listOf(
                JSONPlaceholderAPIUser(
                        id = 12,
                        name = "Charlie Davis",
                        username = "cdavis",
                        emailAddress = "cdavis@jmail.com",
                        address = JSONPlaceholderAPIAddress(
                                street = "1 Main St",
                                suite = "Suite 2B",
                                city = "Boston",
                                zipcode = "12345-6789",
                                geo = JSONPlaceholderAPIGeo(lat = "77.7", lng = "99.9")
                        ),
                        phone = "703-555-1212",
                        website = "http://www.google.com",
                        company = JSONPlaceholderAPICompany(
                                name = "ABC Mart",
                                catchPhrase = "Here for you!",
                                bs = "Interesting"
                        )
                )
        )
        val actualUsers = usersRepository.getAll()


        val expectedUsers = listOf(
                User(12, "cdavis", "Charlie Davis", "cdavis@jmail.com")
        )
        assertThat(actualUsers, equalTo(expectedUsers))
    }
}
