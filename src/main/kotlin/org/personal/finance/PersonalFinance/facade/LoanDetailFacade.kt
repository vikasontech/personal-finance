package org.personal.finance.personalFinance.facade

import org.personal.finance.personalFinance.docs.LoanDetail
import reactor.core.publisher.Mono

interface LoanDetailFacade {
    fun save(loanDetail: LoanDetail): Mono<LoanDetail>
}
