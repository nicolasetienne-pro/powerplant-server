package com.net.apps.powerplant.server.rest.v3;

import com.net.apps.powerplant.server.core.converter.Converter;
import com.net.apps.powerplant.server.core.v3.Message;
import com.net.apps.powerplant.server.rest.impls.PingApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Component("PingResourceV3")
public class PingRest implements PingRestApi, Converter{
    @Autowired
    private PingApiService pingApiService;
    private final AtomicLong counter = new AtomicLong();

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Fait un ping", notes = "", response = Void.class, tags = {"statut",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Void.class)})
    public Message ping(){
        Message messageV3 = convert(pingApiService.ping(), Message.class);
        messageV3.setMessage("It Work's");
        return messageV3;
    }
}
