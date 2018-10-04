package com.udacity.gradle.builditbigger.backend;

import com.example.lib.JokeLibrary;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    //Here I'm using the java library i created to get that one joke I discovered on reddit :D

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() {
        JokeLibrary jl =new JokeLibrary();
        MyBean response = new MyBean();
        response.setData(jl.getJoke());
        return response;
    }

}
