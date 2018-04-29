package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.ApiResponseMessage;
import com.net.apps.powerplant.server.core.Releve;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.impls.ReleveApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Component
public class ReleveRest implements ReleveRestApi {

    @Autowired
    private ReleveApiService delegate;

    @Override
    public Response addReleve(Releve releve) {
        try {
            Releve releveAdded = delegate.addReleve(releve);
            return Response.ok().entity(releveAdded).build();
        } catch (NotFoundException e) {
            ApiResponseMessage apiResponseMessage = new ApiResponseMessage(ApiResponseMessage.OK, e.getMessage());
            return Response.notModified().entity(apiResponseMessage).build();
        }
    }

    @Override
    public Response getReleves(Integer plantId, Integer userId){
        try {
            List<Releve> releves = delegate.getReleves(plantId, userId);
            return Response.ok().entity(releves).build();
        } catch (NotFoundException e) {
            ApiResponseMessage apiResponseMessage = new ApiResponseMessage(ApiResponseMessage.OK, e.getMessage());
            return Response.notModified().entity(apiResponseMessage).build();
        }
    }
}
