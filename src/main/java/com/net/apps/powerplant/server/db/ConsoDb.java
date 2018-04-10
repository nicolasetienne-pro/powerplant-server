package com.net.apps.powerplant.server.db;

import java.util.Date;

public class ConsoDb {
    private Integer id;

    private Integer plantId;

    private Integer userId;

    private Date consodate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getConsodate() {
        return consodate;
    }

    public void setConsodate(Date consodate) {
        this.consodate = consodate;
    }
}