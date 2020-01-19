package org.personal.finance.service.impl

import org.personal.finance.docs.LoanDetail
import org.personal.finance.docs.LoanDetailRepo
import org.personal.finance.service.LoanDetailService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class LoanDetailServiceImpl(val loannDetailRepo:  LoanDetailRepo) : LoanDetailService {

    override fun save(loanDetail: LoanDetail): Mono<LoanDetail> {
        return loannDetailRepo.save(loanDetail)

    }
}