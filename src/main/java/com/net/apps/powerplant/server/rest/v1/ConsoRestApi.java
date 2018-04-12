package com.net.apps.powerplant.server.rest.v1;


import com.net.apps.powerplant.server.core.Conso;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/v1/releve")
@Api(description = "the conso API")
public interface ConsoRestApi {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Add a new conso on a plant", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"releve",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    default Response addReleve(
            @ApiParam(value = "Releve to add", required = true) Conso conso,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

//    @PUT
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    @ApiOperation(value = "Update an existing plant", notes = "", response = Void.class, authorizations = {
//            @Authorization(value = "plant_auth", scopes = {
//                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
//                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
//            })
//    }, tags = {"releve",})
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
//            @ApiResponse(code = 404, message = "Plant not found", response = Void.class),
//            @ApiResponse(code = 405, message = "Validation exception", response = Void.class)})
//    default Response updatePlant(@ApiParam(value = "Plant object that needs to be added", required = true) Plant body
//            , @Context SecurityContext securityContext)
//            throws NotFoundException {
//        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
//    }

//    @GET
//    @Path("/{plantId}/user/{userId}")
//    @Produces({MediaType.APPLICATION_JSON})
//    @ApiOperation(value = "Find plant by ID", notes = "Returns a single plant", response = Plant.class, authorizations = {
//            @Authorization(value = "plant_auth", scopes = {
//                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
//                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
//            })
//    }, tags = {"releve",})
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "successful operation", response = Plant.class),
//            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
//            @ApiResponse(code = 404, message = "Plant not found", response = Void.class)})
//    default Response getPlantById(
//            @ApiParam(value = "ID of plant to return")
//            @PathParam("plantId") String plantId
//            , @Context SecurityContext securityContext)
//            throws NotFoundException {
//        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
//    }
//
}
