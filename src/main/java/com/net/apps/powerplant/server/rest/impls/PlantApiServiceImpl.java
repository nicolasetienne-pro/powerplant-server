package com.net.apps.powerplant.server.rest.impls;


import com.net.apps.powerplant.server.core.ApiResponseMessage;
import com.net.apps.powerplant.server.core.converter.Converter;
import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.core.PlantType;
import com.net.apps.powerplant.server.db.ConsoDb;
import com.net.apps.powerplant.server.db.PlantDb;
import com.net.apps.powerplant.server.db.PlantTypeDb;
import com.net.apps.powerplant.server.db.dao.PlantDao;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.utils.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
class PlantApiServiceImpl implements PlantApiService, Converter {

    @Autowired
    PlantDao plantDao;

    private Plant convert(PlantDb plantDb){
        Plant plant = convert(plantDb, Plant.class);
        if(plantDb.getPlantTypeId() != null) {
            PlantTypeDb plantTypeDb = plantDao.findPlantTypeById(plantDb.getPlantTypeId());
            if (plantTypeDb != null) {
                plant.setType(convert(plantTypeDb, PlantType.class));
            }
        }
        return plant;
    }
    private List<Plant> convertList(List<PlantDb> plantsDbs) {
        return StreamUtils.stream(plantsDbs)
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Response addPlant(Plant plant, SecurityContext securityContext) throws NotFoundException {
        PlantDb plantDb = convert(plant, PlantDb.class);
        Integer plantTypeId = plant.getType().getId();
        plantDb.setPlantTypeId(plantTypeId);

        if (plantTypeId != null && plantDao.create(plantDb)) {
            List<ConsoDb> consoDbList = convertList(plant.getConsumptions(), ConsoDb.class);
            consoDbList.forEach(consoDb -> {
                consoDb.setPlantId(plantDb.getId());
            });
            return getPlantById(plantDb.getId(), securityContext);
        } else {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "PlantDb creation failed")).build();
        }
    }

    @Override
    public Response deletePlant(Long plantId, String apiKey, SecurityContext securityContext) throws NotFoundException {
        PlantDb plantDb = plantDao.findById(plantId.intValue());
        if (plantDb != null) {
            plantDao.delete(plantDb);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Plant " + plantId + " sucessfully deleted")).build();
        }
        return Response.notModified().entity(new ApiResponseMessage(ApiResponseMessage.OK, "No plant found for id: " + plantId)).build();
    }

    @Override
    public Response getPlantById(Integer plantId, SecurityContext securityContext) throws NotFoundException {
        PlantDb plantDb = plantDao.findById(plantId.intValue());
        if (plantDb != null) {
            Plant plant = convert(plantDb);
            return Response.ok().entity(plant).build();
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "No plant found for id: " + plantId)).build();
    }

    @Override
    public Response getPlants(SecurityContext securityContext) throws NotFoundException {
        List<PlantDb> plantsDbs = plantDao.findPlants();
        if (plantsDbs != null) {
            List<Plant> plants = convertList(plantsDbs);
//            List<Plant> plants = convertList(plantsDbs, Plant.class);
            return Response.ok().entity(plants).build();
        }
        return Response.noContent().entity(new ApiResponseMessage(ApiResponseMessage.OK, "No plant found")).build();
    }

    @Override
    public Response getPlantsTypes(SecurityContext securityContext) {
        List<PlantTypeDb> plantTypes = plantDao.findPlantTypes();
        if (plantTypes != null) {
            return Response.ok(plantTypes).build();
        }
        return Response.noContent().entity(new ApiResponseMessage(ApiResponseMessage.OK, "No plant types found")).build();
    }

    @Override
    public Response updatePlant(Plant plant, SecurityContext securityContext) throws NotFoundException {
        PlantDb plantDb = convert(plant, PlantDb.class);
        if (plantDao.update(plantDb)) {

//            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "")).build();
            return getPlantById(plantDb.getId(), securityContext);
        }

        return Response.notModified().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Plant not modified")).build();
    }
}