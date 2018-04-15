package com.net.apps.powerplant.server.core.converter;

import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.core.PlantType;
import com.net.apps.powerplant.server.db.PlantDb;
import com.net.apps.powerplant.server.db.PlantTypeDb;

public interface PlantConverter extends Converter {

//    default Plant convertToReleve(PlantDb plantDb){
//        Plant plant = convertToReleve(plantDb, Plant.class);
//        PlantTypeDb plantTypeDb = plantDao.findPlantTypeById(plantDb.getPlantTypeId());
//        if(plantTypeDb != null){
//            plant.setType(convertToReleve(plantTypeDb, PlantType.class));
//        }
//    }
}
