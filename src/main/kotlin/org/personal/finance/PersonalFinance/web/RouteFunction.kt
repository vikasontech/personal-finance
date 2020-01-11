package org.personal.finance.personalFinance.web

import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import reactor.core.publisher.Mono
import springfox.documentation.service.Server

@RestController
class LoanDetailController (val loanDetailFacade: LoanD) {

    fun  routes(myHandler: MyHandler) : RouterFunction<ServerResponse>{
        return RouterFunctions.route(GET("/people/{id}").and(accept(APPLICATION_JSON)),
                HandlerFunction { t -> myHandler.get(t) })
    }
}

@Component
class MyHandler {

    fun get( request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
                .ok()
                .body(Mono.just("Hello from flux"), String.javaClass)
    }
}