package org.personal.finance.service

import org.personal.finance.docs.LoanDetail
import reactor.core.publisher.Mono

interface LoanDetailService {
    fun save(loanDetail: LoanDetail): Mono<LoanDetail>
}
