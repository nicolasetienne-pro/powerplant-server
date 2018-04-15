package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.Releve;
import com.net.apps.powerplant.server.db.ReleveDb;
import com.net.apps.powerplant.server.db.dao.ReleveDao;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReleveApiServiceImpl implements ReleveApiService {

    @Autowired
    ReleveDao releveDao;

    @Override
    public Releve addReleve(Releve releve) throws NotFoundException {
        ReleveDb db = convertToReleveDb(releve);
        if (releveDao.create(db)) {
            try {
                return getConsoById(db.getId());
            } catch (NotFoundException e){
                //TODO LOG DEBUG
            }
        }
        throw new NotFoundException(500, "Aucun releve ajoute");

    }

    public Releve getConsoById(Integer id) throws NotFoundException {
        ReleveDb consoDb = releveDao.findById(id);
        if (consoDb != null) {
            return convertToReleve(consoDb);
        }
        throw new NotFoundException(500, "No releve found for id: " + id);
    }

    @Override
    public List<Releve> getReleves(Integer plantId, Integer userId) throws NotFoundException {
        List<ReleveDb> releveDbList = releveDao.findByPlantId(plantId);
        return convertToReleveList(releveDbList);
    }
}
