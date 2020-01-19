package org.personal.finance

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersonalFinanceApplication

fun main(args: Array<String>) {
	runApplication<PersonalFinanceApplication>(*args)
}
