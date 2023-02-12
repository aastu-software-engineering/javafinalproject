package io.ruth.quizapp.controllers;

import io.ruth.quizapp.DTO.LoginDto;
import io.ruth.quizapp.entities.Admin;
import io.ruth.quizapp.services.IAdminService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admin")
public class AdminController {
    @Inject
    private IAdminService adminService;
    public AdminController() {
    }
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDto){
        try{
            return Response.ok(adminService.login(loginDto)).build();
        }catch (Exception e) {
            System.out.println(e);
            return Response.status(400).build();
        }
    }
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerAdmin(Admin admin){
        try{
            return Response.ok(adminService.registerAdmin(admin)).build();
        }catch (Exception e) {
            System.out.println(e);
            return Response.status(400).build();
        }
    }

}
