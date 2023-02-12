package io.ruth.quizapp.controllers;

import io.ruth.quizapp.DTO.LoginDto;
import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.exceptions.AuthenticationException;
import io.ruth.quizapp.services.IExamineeService;
import io.ruth.quizapp.services.IQuizService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/examinee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExamineeController {
    @Inject
    private IExamineeService examineService;
    @Inject
    private IQuizService quizService;
    public ExamineeController() {
        
    }
    @GET
    @Path("{id}")
    public Response getInformation(@PathParam("id") int id) {
        try {
            return Response.ok(examineService.getInformation(id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    //TODO: list of quizzes the person take
    //not tested
    @GET
    @Path("/{id}/score/{quizId}")
    public Response seeScore(@PathParam("id") int id, @PathParam("quizId") int quizId) {
        try {
            return Response.ok(quizService.seeScore(id, quizId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/register")
    public Response register(Examinee ex) {
        try {
            return Response.ok(examineService.register(ex)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
            //return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @POST
    @Path("/login")
    public Response login(LoginDto ex) {
        try {
            return Response.ok(examineService.login(ex)).build();
        } catch (AuthenticationException e) {
            System.out.println("AuthenticationException");
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            System.out.println("Exception");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PUT
    @Path("/edit/{id}")
    public Response editProfile(Examinee ex, @PathParam("id") int id) {
        try {
            return Response.ok(examineService.editProfile(ex, id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
