package org.personal.finance.personalFinance.web

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@WebFluxTest(value = arrayOf(AnotherController::class))
internal class AnotherControllerTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun sample() {
        val jsonPath = webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk
    }
}

