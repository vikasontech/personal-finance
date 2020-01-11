package org.personal.finance.personalFinance.facade

import org.personal.finance.personalFinance.docs.LoanDetail
import reactor.core.publisher.Flux

interface QueryLoanDetailFacade {
    fun find(): Flux<LoanDetail>
}
