package org.personal.finance.personalFinance.facade.impl

import io.github.benas.randombeans.EnhancedRandomBuilder
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.service.LoanDetailService
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@RunWith(MockitoJUnitRunner::class)
internal class LoanDetailFacadeImplTest {
    @Mock lateinit var loanDetailService: LoanDetailService
    @InjectMocks lateinit var loanDetailFacadeImpl: LoanDetailFacadeImpl

    @Test
    fun `save loan detail form`() {
        val loanDetail = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .build()
                .nextObject(LoanDetail::class.java)

        Mockito.`when`(loanDetailService.save(loanDetail)).thenReturn(Mono.just(loanDetail))

        StepVerifier.create( loanDetailFacadeImpl.save(loanDetail))
                .expectSubscription()
                .expectNextCount(1)
                .verifyComplete()
    }
}