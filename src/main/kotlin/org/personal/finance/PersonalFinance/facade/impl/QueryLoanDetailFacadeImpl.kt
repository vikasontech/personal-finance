package org.personal.finance.personalFinance.facade.impl

import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.facade.QueryLoanDetailFacade
import reactor.core.publisher.Flux

class QueryLoanDetailFacadeImpl : QueryLoanDetailFacade {
    override fun find(): Flux<LoanDetail> {
        TODO()
    }
}