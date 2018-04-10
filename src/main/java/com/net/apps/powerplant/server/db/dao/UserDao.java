package com.net.apps.powerplant.server.db.dao;

import com.net.apps.powerplant.server.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserDao {

    @Autowired
    private UserMapper userMapper;


}
