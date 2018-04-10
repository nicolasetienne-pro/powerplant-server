package com.net.apps.powerplant.server.rest.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/v1/ping")
@Api(description = "the ping API")
public interface PingRestApi {
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Fait un ping", notes = "", response = Void.class, tags = {"statut",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Void.class)})
    default Response ping(){
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
