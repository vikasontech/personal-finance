package org.personal.finance.personalFinance.service

import org.personal.finance.personalFinance.docs.LoanDetail

interface LoanDetailService {
    fun save(loanDetail: LoanDetail)
}
