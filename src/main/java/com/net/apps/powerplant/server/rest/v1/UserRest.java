package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.impls.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Component
public class UserRest implements UserRestApi {

    @Autowired
    private UserApiService delegate;

    @Override
    public Response createUser(User body, SecurityContext securityContext) throws NotFoundException {
        return delegate.createUser(body, securityContext);
    }

    @Override
    public Response deleteUser(String username, SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteUser(username, securityContext);
    }

    @Override
    public Response getUserByName(String username, SecurityContext securityContext) throws NotFoundException {
        return delegate.getUserByName(username, securityContext);
    }

    @Override
    public Response loginUser(String username, String password, SecurityContext securityContext) throws NotFoundException {
        return delegate.loginUser(username, password, securityContext);
    }

    @Override
    public Response logoutUser(SecurityContext securityContext) throws NotFoundException {
        return delegate.logoutUser(securityContext);
    }

    @Override
    public Response updateUser(String username, User body, SecurityContext securityContext) throws NotFoundException {
        return delegate.updateUser(username, body, securityContext);
    }
}
