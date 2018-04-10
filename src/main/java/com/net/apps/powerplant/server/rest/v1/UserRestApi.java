package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("/v1/user")
@Api(description = "the user API")
public interface UserRestApi {
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.", response = Void.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Void.class)})
    default Response createUser(@ApiParam(value = "Created user object", required = true) User body
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @DELETE
    @Path("/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.", response = Void.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid username supplied", response = Void.class),
            @ApiResponse(code = 404, message = "User not found", response = Void.class)})
    default Response deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) @PathParam("username") String username
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @GET
    @Path("/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get user by user name", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = User.class),
            @ApiResponse(code = 400, message = "Invalid username supplied", response = Void.class),
            @ApiResponse(code = 404, message = "User not found", response = Void.class)})
    default Response getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathParam("username") String username
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Logs user into the system", notes = "", response = String.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = String.class),

            @ApiResponse(code = 400, message = "Invalid username/password supplied", response = Void.class)})
    default Response loginUser(@ApiParam(value = "The user name for login", required = true) @QueryParam("username") String username
            , @ApiParam(value = "The password for login in clear text", required = true) @QueryParam("password") String password
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @GET
    @Path("/logout")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Void.class)})
    default Response logoutUser(@Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @PUT
    @Path("/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.", response = Void.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid user supplied", response = Void.class),
            @ApiResponse(code = 404, message = "User not found", response = Void.class)})
    default Response updateUser(@ApiParam(value = "name that need to be updated", required = true) @PathParam("username") String username
            , @ApiParam(value = "Updated user object", required = true) User body
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
