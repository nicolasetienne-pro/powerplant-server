package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public interface PlantApiService {
    Response addPlant(Plant body, SecurityContext securityContext) throws NotFoundException;
    Response deletePlant(Long plantId,String apiKey,SecurityContext securityContext) throws NotFoundException;
    Response getPlantById(Integer plantId,SecurityContext securityContext) throws NotFoundException;
    Response getPlants(SecurityContext securityContext) throws NotFoundException;
    Response updatePlant(Plant body,SecurityContext securityContext) throws NotFoundException;
    Response getPlantsTypes(SecurityContext securityContext);
}
