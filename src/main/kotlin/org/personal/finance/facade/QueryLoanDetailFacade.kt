package org.personal.finance.facade

import org.personal.finance.docs.LoanDetail
import reactor.core.publisher.Flux

interface QueryLoanDetailFacade {
    fun find(): Flux<LoanDetail>
}
