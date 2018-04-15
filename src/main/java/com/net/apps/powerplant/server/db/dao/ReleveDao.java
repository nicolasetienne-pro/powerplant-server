package com.net.apps.powerplant.server.db.dao;

import com.net.apps.powerplant.server.db.ReleveDb;
import com.net.apps.powerplant.server.db.ReleveDbExample;
import com.net.apps.powerplant.server.db.mapper.ReleveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReleveDao {
    @Autowired
    ReleveMapper releveMapper;

    public boolean create(ReleveDb consoDb) {
        return releveMapper.insert(consoDb) > 0;
    }

    public ReleveDb findById(Integer id){
        return releveMapper.selectByPrimaryKey(id);
    }

    public List<ReleveDb> findByPlantId(Integer plantId){
        ReleveDbExample example = new ReleveDbExample();
        example.createCriteria().andPlantIdEqualTo(plantId);
        example.setOrderByClause("TIMESTAMP DESC");
        return releveMapper.selectByExample(example);
    }

}
