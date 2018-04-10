package com.net.apps.powerplant.server.rest.v1;

import com.net.apps.powerplant.server.core.Plant;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.rest.impls.PlantApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Component
public class PlantRest implements PlantRestApi {

    @Autowired
    private PlantApiService delegate;

    @Override
    public Response addPlant(Plant body, SecurityContext securityContext) throws NotFoundException {
        return delegate.addPlant(body, securityContext);
    }

    @Override
    public Response deletePlant(Long plantId, String apiKey, SecurityContext securityContext) throws NotFoundException {
        return delegate.deletePlant(plantId, apiKey, securityContext);
    }

    @Override
    public Response getPlantById(String plantId, SecurityContext securityContext) throws NotFoundException {
        return delegate.getPlantById(StringUtils.isNotBlank(plantId) ? Integer.valueOf(plantId): null, securityContext);
    }

    @Override
    public Response getPlants(SecurityContext securityContext) throws NotFoundException {
        return delegate.getPlants(securityContext);
    }
    @Override
    public Response getPlantsTypes(SecurityContext securityContext) throws NotFoundException {
        return delegate.getPlantsTypes(securityContext);
    }

    @Override
    public Response updatePlant(Plant body, SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePlant(body, securityContext);
    }
}
