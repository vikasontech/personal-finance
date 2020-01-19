package org.personal.finance.docs

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate

@Document
data class LoanDetail(var _id: String,
                      var loanAmount: BigDecimal,
                      var loanCommencedDate: LocalDate,
                      var interestRate: Float,
                      var numberOfEmi: Int,
                      var emiAmount: BigDecimal)
