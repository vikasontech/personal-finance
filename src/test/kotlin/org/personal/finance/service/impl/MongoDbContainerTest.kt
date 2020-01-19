package org.personal.finance.service.impl


import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Configuration
import org.testcontainers.containers.GenericContainer

class MongoContainer( image: String) : GenericContainer<MongoContainer>(image)

@Configuration
class MongoContainerInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    val image:String =  "mongo:4.2.0-rc2-bionic"
    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
        val mongoContainer = MongoContainer(image)
        mongoContainer.start()
        val connectURl =  "spring.data.mongodb.uri="+ "mongodb://${mongoContainer.getContainerIpAddress()}:${mongoContainer.getMappedPort(27017)}/test"
        println(">>>>>>>>>>>>>>>>Connection url: $connectURl")
        TestPropertyValues.of(
                connectURl
        ).applyTo(configurableApplicationContext.environment)
    }
}
//>>>>>>>>>>>>>>>>Connection url: spring.data.mongodb.uri=mongodb://localhost:32793/test

