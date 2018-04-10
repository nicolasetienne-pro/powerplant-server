package com.net.apps.powerplant.server.rest.v1;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component("PingResourceV1")
public class PingRest implements PingRestApi {

    @Override
    public Response ping()  {
        return Response.ok("OK").build();
    }
}
