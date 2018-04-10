package com.net.apps.powerplant.server.db.mapper;

import com.net.apps.powerplant.server.db.PlantDb;
import com.net.apps.powerplant.server.db.PlantDbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PlantMapper {
    long countByExample(PlantDbExample example);

    int deleteByExample(PlantDbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlantDb record);

    int insertSelective(PlantDb record);

    List<PlantDb> selectByExample(PlantDbExample example);

    PlantDb selectByPrimaryKey(Integer id);

    long selectLastInsertedId();

    int updateByExampleSelective(@Param("record") PlantDb record, @Param("example") PlantDbExample example);

    int updateByExample(@Param("record") PlantDb record, @Param("example") PlantDbExample example);

    int updateByPrimaryKeySelective(PlantDb record);

    int updateByPrimaryKey(PlantDb record);
}