package io.ruth.quizapp.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/quiz")
public class QuizController {

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}
