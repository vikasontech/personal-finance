package org.personal.finance.personalFinance.web

import org.junit.runner.Request
import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.facade.LoanDetailFacade
import org.personal.finance.personalFinance.facade.QueryLoanDetailFacade
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import javax.print.attribute.standard.Media

@Configuration
class LoanDetailRoutes {

    @Bean
    fun route(loanDetailRouteHandler: LoanDetailRouteHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
                .route(RequestPredicates.GET("/api/v1/loan/detail/save")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
//                        .and (RequestPredicates.contentType(MediaType.APPLICATION_JSON)
                        ,
                        HandlerFunction { request: ServerRequest ->  ServerResponse.ok().build()}

                )


    }
}


@Component
class LoanDetailRouteHandler {
    lateinit var  loanDetailFacade: LoanDetailFacade

    fun handle(request: ServerRequest): Mono<ServerResponse> {
        val loanDetailMono = request.bodyToMono(LoanDetail::class.java)
                .flatMap { loanDetailFacade.save(it) }

        val t: Mono<ServerResponse> =  ServerResponse.created(UriComponentsBuilder.fromPath("/detail/save").build().toUri())
                .contentType(MediaType.APPLICATION_JSON)
                .body<LoanDetail>(EntityResponse.fromPublisher(
                        loanDetailMono ,
                        LoanDetail::class.java
                ))
        return t
    }
//        override fun handle(request: ServerRequest): Mono<ServerResponse> {
//        val loanDetail = request.bodyToMono<LoanDetail>()
//        return loanDetail
//                .map { loanDetailFacade.save(it) }
//                .flatMap { ServerResponse.ok().body(it) }
//                .map { HandlerFunction {  }}
//    }
}