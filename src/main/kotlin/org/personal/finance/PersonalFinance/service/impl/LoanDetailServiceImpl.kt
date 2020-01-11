package org.personal.finance.personalFinance.service.impl

import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.docs.LoanDetailRepo
import org.personal.finance.personalFinance.service.LoanDetailService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class LoanDetailServiceImpl(val repo: LoanDetailRepo) : LoanDetailService {

    override fun save(loanDetail: LoanDetail): Mono<LoanDetail> {
        return repo.save(loanDetail)
    }
}
