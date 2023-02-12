package io.ruth.quizapp.controllers;

import io.ruth.quizapp.DTO.CreateQuizDto;
import io.ruth.quizapp.DTO.SubmitQuizDto;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;
import io.ruth.quizapp.services.IQuizService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/quiz")
public class QuizController {
    @Inject
    private IQuizService quizService;
    public QuizController() {
    }
    @GET
    @Path("/start/{id}/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startQuiz(@PathParam("id") int id, @PathParam("quizId") int quizId){
        try {
            Quiz quiz = quizService.takeQuiz(id, quizId);
            return Response.ok(quiz).build();
        } catch (Exception e){
            return Response.status(400).build();
        }
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
    public Response gradeQuiz(@PathParam("id") int id, @PathParam("quizId") int quizId, SubmitQuizDto quizDto) {
            try{
                return Response.ok(quizService.gradeQuiz(id,quizId,quizDto.getAnswers())).build();
            } catch (Exception e){
                return Response.status(400).build();
            }
    }
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createQuiz(CreateQuizDto quizDto){
        System.out.println(quizDto.getQuestions().size());
        if(quizDto.getQuestions().size() == 0){
            return Response.status(400).build();
        }
        Quiz quiz = quizService.createQuiz(quizDto);
        try{
            return Response.ok(quiz).build();
        } catch (Exception e){
            return Response.status(400).build();
        }
    }
    @GET
    @Path("/all/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuizzes(@PathParam("id") int id){
        try{
            return Response.ok(quizService.getAllQuizzes(id)).build();
        } catch (Exception e){
            System.out.println(e);
            return Response.status(400).build();
        }
    }
    @GET
    @Path("/stats/{adminId}/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuizStats(@PathParam("adminId") int adminId, @PathParam("quizId") int quizId){
        try{
            return Response.ok(quizService.getQuizStats(adminId,quizId)).build();
        } catch (Exception e){
            System.out.println(e);
            return Response.status(400).build();
        }
    }
}
