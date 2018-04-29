package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.ApiResponseMessage;
import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.impls.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Component
public class UserRest implements UserRestApi {

    @Autowired
    private UserApiService delegate;

    @Override
    public Response createUser(User user) throws NotFoundException {
        try {
            User userCreated = delegate.createUser(user);
            return Response.ok().entity(userCreated).build();
        } catch (NotFoundException e) {
            ApiResponseMessage apiResponseMessage = new ApiResponseMessage(ApiResponseMessage.OK, e.getMessage());
            return Response.notModified().entity(apiResponseMessage).build();
        }
    }

    @Override
    public Response deleteUser(String username) throws NotFoundException {
        return delegate.deleteUser(username);
    }

    @Override
    public Response getUserByName(String username) throws NotFoundException {
        try {
            User user = delegate.getUserByName(username);
            return Response.ok().entity(user).build();
        } catch (NotFoundException e) {
            ApiResponseMessage apiResponseMessage = new ApiResponseMessage(ApiResponseMessage.OK, e.getMessage());
            return Response.noContent().entity(apiResponseMessage).build();
        }
    }

    @Override
    public Response loginUser(String login, String password) throws NotFoundException {
        return delegate.loginUser(login, password);
    }

    @Override
    public Response logoutUser() throws NotFoundException {
        return delegate.logoutUser();
    }

    @Override
    public Response updateUser(String username, User body) throws NotFoundException {
        return delegate.updateUser(username, body);
    }

    @Override
    public List<User> getUsers() throws NotFoundException {
        return delegate.getUsers();
    }
}
