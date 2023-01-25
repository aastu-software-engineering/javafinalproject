package io.ruth.quizapp.controllers;

import io.ruth.quizapp.DTO.Answer;
import io.ruth.quizapp.DTO.SubmitQuizDto;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;
import io.ruth.quizapp.services.QuizService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;

import java.awt.*;
import java.util.ArrayList;

@Path("/quiz")
public class QuizController {
    QuizService quizService;
    @GET
    @Path("/start/{id}/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Quiz startQuiz(@PathParam("id") int id, @PathParam("quizId") int quizId){
        return quizService.takeQuiz(id,quizId);
    }
    @GET
    @Path("/retake/{id}/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Quiz retakeQuiz(@PathParam("id") int id, @PathParam("quizId") int quizId){
        return quizService.retakeQuiz(id,quizId);
    }
    @GET
    @Path("/score/{id}/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result seeScore(@PathParam("id") int id, @PathParam("quizId") int quizId){
        return quizService.seeScore(id,quizId);
    }
    @POST
    @Path("/grade/{id}/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public float gradeQuiz(@PathParam("id") int id, @PathParam("quizId") int quizId, SubmitQuizDto quizDto) {
            ArrayList<Answer> providedAns = quizDto.getAnswers();
            return quizService.gradeQuiz(id, quizId, providedAns);
    }

}
