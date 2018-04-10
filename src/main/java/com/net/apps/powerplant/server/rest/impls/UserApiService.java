package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public interface UserApiService {
    Response createUser(User body, SecurityContext securityContext) throws NotFoundException;
    Response deleteUser(String username,SecurityContext securityContext) throws NotFoundException;
    Response getUserByName(String username,SecurityContext securityContext) throws NotFoundException;
    Response loginUser( @NotNull String username, @NotNull String password,SecurityContext securityContext) throws NotFoundException;
    Response logoutUser(SecurityContext securityContext) throws NotFoundException;
    Response updateUser(String username,User body,SecurityContext securityContext) throws NotFoundException;
}
