package org.personal.finance.web

import org.personal.finance.docs.LoanDetail
import org.personal.finance.facade.LoanDetailFacade
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/loan")
class LoanDetailController (val loanDetailFacade: LoanDetailFacade) {

    @PostMapping("/create", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun save(@RequestBody loadDetail: LoanDetail):Mono<LoanDetail> {
        return loanDetailFacade.save(loadDetail)
    }
}
