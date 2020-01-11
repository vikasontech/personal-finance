package org.personal.finance.personalFinance.docs

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LoanDetailRepo : ReactiveCrudRepository<LoanDetail, String>
