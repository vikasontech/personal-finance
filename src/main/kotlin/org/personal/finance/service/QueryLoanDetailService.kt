package org.personal.finance.service

import org.personal.finance.docs.LoanDetail
import reactor.core.publisher.Flux

interface QueryLoanDetailService {
    fun find(): Flux<LoanDetail>
}