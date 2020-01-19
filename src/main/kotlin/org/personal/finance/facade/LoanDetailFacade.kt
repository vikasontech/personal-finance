package org.personal.finance.facade

import org.personal.finance.docs.LoanDetail
import reactor.core.publisher.Mono

interface LoanDetailFacade {
    fun save(loanDetail: LoanDetail): Mono<LoanDetail>
}
