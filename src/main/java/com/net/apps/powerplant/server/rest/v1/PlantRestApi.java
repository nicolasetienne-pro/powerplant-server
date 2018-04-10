package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.core.PlantType;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/v1/plant")
@Api(description = "the plant API")
public interface PlantRestApi {

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Find all plants", notes = "Returns a single plant", response = Plant.class, responseContainer = "List", authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Plant.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
            @ApiResponse(code = 404, message = "Plant not found", response = Void.class)})
    default Response getPlants(@Context SecurityContext securityContext) throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Add a new plant", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    default Response addPlant(@ApiParam(value = "Plant object that needs to be added", required = true) Plant body
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @DELETE
    @Path("/{plantId}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Deletes a plant", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),

            @ApiResponse(code = 404, message = "Plant not found", response = Void.class)})
    default Response deletePlant(@ApiParam(value = "Plant id to delete", required = true) @PathParam("plantId") Long plantId
            , @ApiParam(value = "") @HeaderParam("api_key") String apiKey
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @GET
    @Path("/{plantId}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Find plant by ID", notes = "Returns a single plant", response = Plant.class, authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Plant.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
            @ApiResponse(code = 404, message = "Plant not found", response = Void.class)})
    default Response getPlantById(
            @ApiParam(value = "ID of plant to return")
            @PathParam("plantId") String plantId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }


    @GET
    @Path("/types")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Find plant type list", notes = "Returns planttype list", response = PlantType.class, responseContainer = "List", authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PlantType.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
            @ApiResponse(code = 404, message = "Plant not found", response = Void.class)})
    default Response getPlantsTypes(@Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Update an existing plant", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
            @ApiResponse(code = 404, message = "Plant not found", response = Void.class),
            @ApiResponse(code = 405, message = "Validation exception", response = Void.class)})
    default Response updatePlant(@ApiParam(value = "Plant object that needs to be added", required = true) Plant body
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @POST
    @Path("/{plantId}")
    @Consumes({"application/x-www-form-urlencoded"})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Updates a plant with form data", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "plant_auth", scopes = {
                    @AuthorizationScope(scope = "read:plants", description = "read your plants"),
                    @AuthorizationScope(scope = "write:plants", description = "modify plants in your account")
            })
    }, tags = {"plant",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    default Response updatePlantWithForm(@ApiParam(value = "ID of plant that needs to be updated", required = true) @PathParam("plantId") Long plantId
            , @ApiParam(value = "Updated name of the plant") @FormParam("name") String name
            , @ApiParam(value = "Updated status of the plant") @FormParam("status") String status
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
