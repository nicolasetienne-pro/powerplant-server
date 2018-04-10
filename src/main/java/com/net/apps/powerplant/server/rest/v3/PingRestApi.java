package com.net.apps.powerplant.server.rest.v3;

import com.net.apps.powerplant.server.core.v3.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/v3/ping")
@Api(description = "the ping API")
public interface PingRestApi {

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Fait un ping", notes = "", response = Void.class, tags = {"statut",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Void.class)})
    Message ping();
}
