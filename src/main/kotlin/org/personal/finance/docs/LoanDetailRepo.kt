package org.personal.finance.docs

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LoanDetailRepo : ReactiveCrudRepository<LoanDetail, String>
