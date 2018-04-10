package com.net.apps.powerplant.server.rest.v2;


import com.net.apps.powerplant.server.rest.impls.PingApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component("PingResourceV2")
public class PingRest implements PingRestApi {
    @Autowired
    private PingApiService pingApiService;

    @Override
    public Response ping(){
        return Response.ok().entity(pingApiService.ping()).build();
    }
}
