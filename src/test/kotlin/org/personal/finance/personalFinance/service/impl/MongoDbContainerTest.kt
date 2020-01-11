package org.personal.finance.personalFinance.service.impl


import org.junit.Test
import org.junit.runner.RunWith
import org.personal.finance.personalFinance.docs.LoanDetail
import org.personal.finance.personalFinance.docs.LoanDetailRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.GenericContainer
import reactor.test.StepVerifier
import java.math.BigDecimal
import java.time.LocalDate

@RunWith(SpringRunner::class)
@SpringBootTest
@ContextConfiguration(initializers = arrayOf(Initializer::class))
class MongoDbContainerTest {

    @Autowired
    private lateinit var repo: LoanDetailRepo

    @Test
    fun sample() {
        StepVerifier.create(repo.save(LoanDetail(_id = "1", loanAmount = BigDecimal.valueOf(100000L),
                emiAmount = BigDecimal.valueOf(1000L),
                interestRate = 10F,
                loanCommencedDate = LocalDate.now(),
                numberOfEmi = 120)))
                .expectSubscription()
                .expectNextCount(1)
                .verifyComplete()
    }
}


@Configuration
class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    val image:String =  "mongo:4.2.0-rc2-bionic"
    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
        val mongoContainer = MongoContainer(image)
        mongoContainer.start()
        val connectURl =  "spring.data.mongodb.uri="+ "mongodb://${mongoContainer.getContainerIpAddress()}:${mongoContainer.getMappedPort(27017)}/test"
        println(">>>>>>>>>>>>>>>>Connection url: $connectURl")
        TestPropertyValues.of(
                "spring.data.mongodb.uri="+ "mongodb://${mongoContainer.getContainerIpAddress()}:${mongoContainer.getMappedPort(27017)}/test"
        ).applyTo(configurableApplicationContext.environment)
    }
}

class MongoContainer( image: String) : GenericContainer<MongoContainer>(image)