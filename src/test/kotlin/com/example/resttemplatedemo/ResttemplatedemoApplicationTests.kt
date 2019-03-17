package com.example.resttemplatedemo

import com.example.resttemplatedemo.users.User
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResttemplatedemoApplicationTests {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun contextLoads() {

    }

    @Test
    fun test_hitting_external_api_with_results() {
        val result = testRestTemplate.exchange(
                "/users",
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<User>>() {}
        )

        
        assertThat(result.statusCode, equalTo(HttpStatus.OK))

        val actualUser = result.body?.first()
        assertThat(actualUser?.id, equalTo(8L))
        assertThat(actualUser?.username, equalTo("Maxime_Nienow"))
        assertThat(actualUser?.name, equalTo("Nicholas Runolfsdottir V"))
        assertThat(actualUser?.email, equalTo("Sherwood@rosamond.me"))
    }
}
