package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.impls.PlantApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class PlantRest implements PlantRestApi {

    @Autowired
    private PlantApiService delegate;

    @Override
    public Response addPlant(Plant body) throws NotFoundException {
        return delegate.addPlant(body);
    }

    @Override
    public Response deletePlant(Long plantId) throws NotFoundException {
        return delegate.deletePlant(plantId);
    }

    @Override
    public Response getPlantById(String plantId) throws NotFoundException {
        return delegate.getPlantById(StringUtils.isNotBlank(plantId) ? Integer.valueOf(plantId): null);
    }

    @Override
    public Response getPlants() throws NotFoundException {
        return delegate.getPlants();
    }
    @Override
    public Response getPlantsTypes() throws NotFoundException {
        return delegate.getPlantsTypes();
    }

    @Override
    public Response updatePlant(Plant body)
            throws NotFoundException {
        return delegate.updatePlant(body);
    }
}
