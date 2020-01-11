package org.personal.finance.personalFinance.web

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.facade.LoanDetailFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.time.LocalDate
import javax.print.attribute.standard.Media


@RunWith(SpringRunner::class)
@WebFluxTest(value = arrayOf(LoanDetailController::class))
internal class LoanDetailControllerTest {

    @MockBean
    lateinit var loanDetailFacade: LoanDetailFacade

    @Autowired
    lateinit var webTestClient: WebTestClient


    @Test
    fun `save loan detail`() {
        val requestBody = Mono.just(LoanDetail(_id = "1", numberOfEmi = 180, loanCommencedDate = LocalDate.now(),
                interestRate = 10F, emiAmount = BigDecimal.valueOf(1200), loanAmount = BigDecimal.valueOf(1200000)))

        webTestClient.post()
                .uri("/api/v1/loan/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .body(requestBody, LoanDetail::class.java)
                .exchange()
                .expectStatus().isOk


    }
}

