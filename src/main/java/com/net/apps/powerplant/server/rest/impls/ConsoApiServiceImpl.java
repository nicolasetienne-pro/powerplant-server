package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.ApiResponseMessage;
import com.net.apps.powerplant.server.core.Conso;
import com.net.apps.powerplant.server.core.User;
import com.net.apps.powerplant.server.core.converter.Converter;
import com.net.apps.powerplant.server.db.ConsoDb;
import com.net.apps.powerplant.server.db.dao.ConsoDao;
import com.net.apps.powerplant.server.utils.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsoApiServiceImpl implements ConsoApiService,Converter  {

    @Autowired
    ConsoDao consoDao;

    private Conso convert(ConsoDb consoDb){
        return convert(consoDb, Conso.class);
    }

    private List<Conso> convertList(List<ConsoDb> consoDbList) {
        return StreamUtils.stream(consoDbList)
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Response addReleve(Conso conso) {
        ConsoDb consoDb = convert(conso, ConsoDb.class);
        consoDb.setDatereleve(conso.getConsoDate() != null ? new Date(conso.getConsoDate().toLocalDate().toEpochDay()) : null);
        if(consoDao.create(consoDb)) {
            return getConsoById(consoDb.getId());
        }
        return Response.notModified().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Aucun releve ajoute")).build();
    }

    private Response getConsoById(Integer id) {
        ConsoDb consoDb = consoDao.findById(id);
        if (consoDb != null) {
            Conso conso = convert(consoDb);
            return Response.ok().entity(conso).build();
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "No plant found for id: " + id)).build();
    }
}
