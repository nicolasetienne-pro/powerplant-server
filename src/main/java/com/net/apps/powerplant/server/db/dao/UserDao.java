package com.net.apps.powerplant.server.db.dao;

import com.net.apps.powerplant.server.db.UserDb;
import com.net.apps.powerplant.server.db.UserDbExample;
import com.net.apps.powerplant.server.db.mapper.UserMapper;
import com.net.apps.powerplant.server.utils.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public UserDb findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public boolean create(UserDb userDb) {
        return userMapper.insert(userDb) > 0;
    }

    public UserDb findUserByLogin(String login){
        UserDbExample example = new UserDbExample();
        example.createCriteria().andLoginEqualTo(login);
        return StreamUtils.stream(userMapper.selectByExample(example))
                .findFirst()
                .orElse(null);
    }

    public boolean update(UserDb userDb){
        int update = userMapper.updateByPrimaryKeySelective(userDb);
        return update > 0;
    }

    public boolean delete(UserDb userDb){
        int deleteByPrimaryKey = userMapper.deleteByPrimaryKey(userDb.getId());
        return deleteByPrimaryKey > 0;
    }

    public List<UserDb> getUsers(){
        return userMapper.selectByExample(new UserDbExample());
    }
}
