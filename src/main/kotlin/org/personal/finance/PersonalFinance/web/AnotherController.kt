package org.personal.finance.personalFinance.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class AnotherController {

    @GetMapping("/hello")
    fun hello(): Mono<String> {
        return Mono.just("hello")
    }

}