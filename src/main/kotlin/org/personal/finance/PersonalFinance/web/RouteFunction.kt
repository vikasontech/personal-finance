package org.personal.finance.personalFinance.web

import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.facade.LoanDetailFacade
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import reactor.core.publisher.Mono
import springfox.documentation.service.Server

@RestController
@RequestMapping("/api/v1/loan")
class LoanDetailController (val loanDetailFacade: LoanDetailFacade) {

    @PostMapping("/create", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun save(@RequestBody loadDetail: LoanDetail):Mono<LoanDetail> {
        return loanDetailFacade.save(loadDetail)
    }
}
