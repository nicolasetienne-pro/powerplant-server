package com.net.apps.powerplant.server.db.mapper;

import com.net.apps.powerplant.server.db.UserDb;
import com.net.apps.powerplant.server.db.UserDbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    long countByExample(UserDbExample example);

    int deleteByExample(UserDbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDb record);

    int insertSelective(UserDb record);

    List<UserDb> selectByExample(UserDbExample example);

    UserDb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDb record, @Param("example") UserDbExample example);

    int updateByExample(@Param("record") UserDb record, @Param("example") UserDbExample example);

    int updateByPrimaryKeySelective(UserDb record);

    int updateByPrimaryKey(UserDb record);
}