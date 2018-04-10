package com.net.apps.powerplant.server.db.mapper;

import com.net.apps.powerplant.server.db.PlantTypeDb;
import com.net.apps.powerplant.server.db.PlantTypeDbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PlantTypeMapper {
    long countByExample(PlantTypeDbExample example);

    int deleteByExample(PlantTypeDbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlantTypeDb record);

    int insertSelective(PlantTypeDb record);

    List<PlantTypeDb> selectByExample(PlantTypeDbExample example);

    PlantTypeDb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlantTypeDb record, @Param("example") PlantTypeDbExample example);

    int updateByExample(@Param("record") PlantTypeDb record, @Param("example") PlantTypeDbExample example);

    int updateByPrimaryKeySelective(PlantTypeDb record);

    int updateByPrimaryKey(PlantTypeDb record);
}