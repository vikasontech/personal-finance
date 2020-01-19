package org.personal.finance.facade.impl

import org.personal.finance.docs.LoanDetail
import org.personal.finance.facade.QueryLoanDetailFacade
import reactor.core.publisher.Flux

class QueryLoanDetailFacadeImpl : QueryLoanDetailFacade {
    override fun find(): Flux<LoanDetail> {
        TODO()
    }
}