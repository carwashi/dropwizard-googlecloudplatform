package com.hypnoticocelot.appengine.helloworldservice

import com.codahale.metrics.servlets.HealthCheckServlet
import com.hypnoticocelot.appengine.helloworldservice.resources.HomeResource
import io.dropwizard.Application
import io.dropwizard.configuration.ResourceConfigurationSourceProvider
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class HelloWorldApplication : Application<HelloWorldConfiguration>() {

    override fun getName(): String {
        return "HelloWorld"
    }

    override fun initialize(bootstrap: Bootstrap<HelloWorldConfiguration>?) {
        bootstrap!!.configurationSourceProvider = ResourceConfigurationSourceProvider()
    }

    @Throws(Exception::class)
    override fun run(configuration: HelloWorldConfiguration, environment: Environment) {
        environment.jersey().register(HomeResource())
        environment.servlets().addServlet("healthcheck", HealthCheckServlet(environment.healthChecks()))
                .addMapping("/_ah/health")
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic fun main(args: Array<String>) {
            HelloWorldApplication().run(*args)
        }
    }
}
