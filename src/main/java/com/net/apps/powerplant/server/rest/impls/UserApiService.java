package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.core.converter.Converter;
import com.net.apps.powerplant.server.db.UserDb;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.utils.StreamUtils;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

public interface UserApiService extends Converter {
    default User convertToUser(UserDb db) {
        User user = convert(db, User.class);
        user.setUsername(db.getLogin());
        return user;
    }

    default UserDb convertToUserDb(User user) {
        UserDb db = convert(user, UserDb.class);
        db.setLogin(user.getUsername());
        return db;
    }
    default List<User> convertToUserList(List<UserDb> releveDbList) {
        return StreamUtils.stream(releveDbList)
                .map(this::convertToUser)
                .collect(Collectors.toList());
    }

    User createUser(User body) throws NotFoundException;

    List<User> getUsers() throws NotFoundException;

    User getUserByName(String username) throws NotFoundException;

    Response deleteUser(String username) throws NotFoundException;
    Response loginUser( @NotNull String username, @NotNull String password) throws NotFoundException;
    Response logoutUser() throws NotFoundException;
    Response updateUser(String username,User body) throws NotFoundException;
}
