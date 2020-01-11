package org.personal.finance.personalFinance.facade.impl

import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.facade.LoanDetailFacade
import org.personal.finance.personalFinance.service.LoanDetailService
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class LoanDetailFacadeImpl(val loanDetailService: LoanDetailService) : LoanDetailFacade {
    override fun save(loanDetail: LoanDetail): Mono<LoanDetail> {
        return loanDetailService.save(loanDetail)
    }
}
