package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.Conso;

import javax.ws.rs.core.Response;

public interface ConsoApiService {
    Response addReleve(Conso conso);
}
