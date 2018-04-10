package com.net.apps.powerplant.server.db.mapper;

import com.net.apps.powerplant.server.db.ConsoDb;
import com.net.apps.powerplant.server.db.ConsoDbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ConsoMapper {
    long countByExample(ConsoDbExample example);

    int deleteByExample(ConsoDbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConsoDb record);

    int insertSelective(ConsoDb record);

    List<ConsoDb> selectByExample(ConsoDbExample example);

    ConsoDb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConsoDb record, @Param("example") ConsoDbExample example);

    int updateByExample(@Param("record") ConsoDb record, @Param("example") ConsoDbExample example);

    int updateByPrimaryKeySelective(ConsoDb record);

    int updateByPrimaryKey(ConsoDb record);
}