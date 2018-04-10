package com.net.apps.powerplant.server.db.dao;

import com.net.apps.powerplant.server.db.PlantDb;
import com.net.apps.powerplant.server.db.PlantDbExample;
import com.net.apps.powerplant.server.db.PlantTypeDb;
import com.net.apps.powerplant.server.db.PlantTypeDbExample;
import com.net.apps.powerplant.server.db.mapper.PlantMapper;
import com.net.apps.powerplant.server.db.mapper.PlantTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PlantDao {
    @Autowired
    private PlantTypeMapper plantTypeMapper;
    @Autowired
    private PlantMapper plantMapper;

    public List<PlantTypeDb> findPlantTypes(){
        return plantTypeMapper.selectByExample(new PlantTypeDbExample());
    }

    public PlantTypeDb findPlantTypeById(int id){
        return plantTypeMapper.selectByPrimaryKey(id);
    }

    public boolean create(PlantDb plantDb){
        if(plantMapper.insert(plantDb)>0) {
            long id = plantMapper.selectLastInsertedId();
            plantDb.setId(Math.toIntExact(id));
            return true;
        }
        return false;
    }

    public List<PlantDb> findPlants(){
        PlantDbExample example = new PlantDbExample();
        return plantMapper.selectByExample(example);
    }

    public PlantDb findById(Integer plantId){
        return plantMapper.selectByPrimaryKey(plantId);
    }

    public boolean update(PlantDb plantDb){
        int update = plantMapper.updateByPrimaryKeySelective(plantDb);
        return update > 0;
    }

    public boolean delete(PlantDb plantDb){
        int deleteByPrimaryKey = plantMapper.deleteByPrimaryKey(plantDb.getId());
        return deleteByPrimaryKey > 0;
    }
}
