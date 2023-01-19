package io.ruth.quizapp.controllers;
import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.services.ExamineeService;
import io.ruth.quizapp.services.QuizService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/examinee")
public class ExamineeController {
    private final ExamineeService examineService = new ExamineeService();
    private final QuizService quizService = new QuizService();
    public ExamineeController() {
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInformation(@PathParam("id") int id) {
        try {
            return Response.ok(examineService.getInformation(id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    //TODO: list of quizzes the person take
    @GET
    @Path("/{id}/score/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response seeScore(@PathParam("id") int id, @PathParam("quizId") int quizId) {
        try {
            return Response.ok(quizService.seeScore(id, quizId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(Examinee ex) {
        try {
            return Response.ok(examineService.register(ex)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editProfile(Examinee ex, @PathParam("id") int id) {
        try {
            return Response.ok(examineService.editProfile(ex, id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
