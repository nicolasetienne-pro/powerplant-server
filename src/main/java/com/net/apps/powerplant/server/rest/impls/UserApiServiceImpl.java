package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.ApiResponseMessage;
import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.db.UserDb;
import com.net.apps.powerplant.server.db.dao.UserDao;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.provider.AppAuthenticator;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Component
@Log
class UserApiServiceImpl implements UserApiService {
    @Autowired
    UserDao userDao;
    @Autowired
    AppAuthenticator authenticator;

    @Override
    public User createUser(User user) throws NotFoundException {
        UserDb db = convertToUserDb(user);
        if (userDao.create(db)) {
            try {
                return findUserById(db.getId());

            } catch (NotFoundException e){
                //TODO LOG DEBUG
            }
        }
        throw new NotFoundException(500, "Aucun releve ajoute");
    }

    private User findUserById(Integer id) throws NotFoundException {
        UserDb userDb = userDao.findById(id);
        if (userDb != null) {
            return convertToUser(userDb);
        }
        throw new NotFoundException(500, "No user found for id: " + id);
    }

    @Override
    public List<User> getUsers() throws NotFoundException {
        return convertToUserList(userDao.getUsers());
    }


    @Override
    public Response deleteUser(String username) throws NotFoundException {
        UserDb db = userDao.findUserByLogin(username);
        if (db != null) {
            if(userDao.delete(db)) {
                return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "User " + username + " sucessfully deleted")).build();
            } else {
                return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.WARNING, "User " + username + " not deleted")).build();
            }
        }
        return Response.notModified().entity(new ApiResponseMessage(ApiResponseMessage.OK, "No user found for login: " + username)).build();

    }

    @Override
    public User getUserByName(String username) throws NotFoundException {
        UserDb db = userDao.findUserByLogin(username);
        if(db != null) {
            return convertToUser(db);
        }
        throw new NotFoundException(500, "No user found for login : " + username);
    }

    @Override
    public Response loginUser(@NotNull String login, @NotNull String password) throws NotFoundException {
        try {

            // Authenticate the user using the credentials provided
            // Issue a token for the user
            String token = authenticator.authenticate(login, password);

            // Return the token on the response
//            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, token)).build();
            return Response.ok("{\"token\": \""+token+"\"}").build();
//            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }



    @Override
    public Response logoutUser() throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateUser(String username, User body) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
