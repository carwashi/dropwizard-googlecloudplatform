package com.hypnoticocelot.appengine.helloworldservice.resources

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/")
class HomeResource {
    @GET
    fun get(): String {
        return "Hello, World!"
    }
}