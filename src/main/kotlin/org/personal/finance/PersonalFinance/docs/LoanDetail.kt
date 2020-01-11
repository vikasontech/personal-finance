package org.personal.finance.personalFinance.docs

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Document
data class LoanDetail(var _id: String,
                      var loanAmount: BigDecimal,
                      var loanCommencedDate: LocalDate,
                      var interestRate: Float,
                      var numberOfEmi: Int,
                      var emiAmount: BigDecimal)
