package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.Releve;
import com.net.apps.powerplant.server.core.converter.Converter;
import com.net.apps.powerplant.server.db.ReleveDb;
import com.net.apps.powerplant.server.rest.exception.NotFoundException;
import com.net.apps.powerplant.server.utils.StreamUtils;

import java.util.List;
import java.util.stream.Collectors;

public interface ReleveApiService extends Converter {

    default Releve convertToReleve(ReleveDb releveDb) {
        Releve releve = convert(releveDb, Releve.class);
        releve.setTimestamp(new java.sql.Date(releveDb.getTimestamp().getTime()).toLocalDate().atStartOfDay());
        return releve;
    }

    default ReleveDb convertToReleveDb(Releve releve) {
        ReleveDb db = convert(releve, ReleveDb.class);
        db.setIndexCompteur(releve.getIndexCompteur());
        db.setPlantId(Math.toIntExact(releve.getPlantId()));
        db.setUserId(Math.toIntExact(releve.getUserId()));
        db.setTimestamp(releve.getTimestamp() != null ? java.sql.Date.valueOf(releve.getTimestamp().toLocalDate()) : new java.util.Date());
        return db;
    }

    default List<Releve> convertToReleveList(List<ReleveDb> releveDbList) {
        return StreamUtils.stream(releveDbList)
                .map(this::convertToReleve)
                .collect(Collectors.toList());
    }

    default List<ReleveDb> convertToReleveDbList(List<Releve> releveList) {
        return StreamUtils.stream(releveList)
                .map(this::convertToReleveDb)
                .collect(Collectors.toList());
    }

    Releve addReleve(Releve releve) throws NotFoundException;

    List<Releve> getReleves(Integer plantId, Integer userId) throws NotFoundException;
}
