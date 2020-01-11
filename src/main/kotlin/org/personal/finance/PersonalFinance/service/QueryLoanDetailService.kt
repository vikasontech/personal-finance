package org.personal.finance.personalFinance.service

import org.personal.finance.personalFinance.docs.LoanDetail
import reactor.core.publisher.Flux

interface QueryLoanDetailService {
    fun find(): Flux<LoanDetail>
}