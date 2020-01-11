package org.personal.finance.personalFinance.service

import org.personal.finance.personalFinance.docs.LoanDetail
import reactor.core.publisher.Mono

interface LoanDetailService {
    fun save(loanDetail: LoanDetail): Mono<LoanDetail>
}
