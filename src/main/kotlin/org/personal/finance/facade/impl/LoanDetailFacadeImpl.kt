package org.personal.finance.facade.impl

import org.personal.finance.docs.LoanDetail
import org.personal.finance.facade.LoanDetailFacade
import org.personal.finance.service.LoanDetailService
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class LoanDetailFacadeImpl(val loanDetailService: LoanDetailService) : LoanDetailFacade {
    override fun save(loanDetail: LoanDetail): Mono<LoanDetail> {
        return loanDetailService.save(loanDetail)
    }
}
