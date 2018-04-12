package com.net.apps.powerplant.server.db.dao;

import com.net.apps.powerplant.server.db.ConsoDb;
import com.net.apps.powerplant.server.db.ConsoDbExample;
import com.net.apps.powerplant.server.db.mapper.ConsoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ConsoDao {
    @Autowired
    ConsoMapper consoMapper;

    public boolean create(ConsoDb consoDb) {

        if(consoMapper.insert(consoDb)>0) {
            long id = consoMapper.selectLastInsertedId();
            consoDb.setId(Math.toIntExact(id));
            return true;
        }
        return false;
    }

    public ConsoDb findById(Integer id){
        return consoMapper.selectByPrimaryKey(id);
    }

    public List<ConsoDb> findByPlantId(Integer plantId){
        ConsoDbExample example = new ConsoDbExample();
        example.createCriteria().andPlantIdEqualTo(plantId);
        return consoMapper.selectByExample(example);
    }

}
