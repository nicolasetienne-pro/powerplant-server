package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.Conso;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.impls.ConsoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Component
public class ConsoRest implements ConsoRestApi {

    @Autowired
    private ConsoApiService delegate;

    @Override
    public Response addReleve(Conso conso, SecurityContext securityContext) throws NotFoundException {
        return delegate.addReleve(conso);
    }
}
