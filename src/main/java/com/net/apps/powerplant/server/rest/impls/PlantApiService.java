package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;

import javax.ws.rs.core.Response;

public interface PlantApiService {
    Response addPlant(Plant body) throws NotFoundException;
    Response deletePlant(Long plantId) throws NotFoundException;
    Response getPlantById(Integer plantId) throws NotFoundException;
    Response getPlants() throws NotFoundException;
    Response updatePlant(Plant body) throws NotFoundException;
    Response getPlantsTypes();
}
