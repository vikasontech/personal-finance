package org.personal.finance.personalFinance.web

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.personal.finance.personalFinance.docs.LoanDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.body
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class LoanDetailRoutesTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient


    @Test
    fun savePost() {
        val requstBody = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
                .nextObject(LoanDetail::class.java)
        webTestClient
                .get()
                .uri("/api/v1/loan/detail/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(requstBody), LoanDetail::class.java)
                .exchange()
                .expectStatus().isOk
    }
}
