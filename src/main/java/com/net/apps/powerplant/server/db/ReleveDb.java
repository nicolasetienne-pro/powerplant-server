package com.net.apps.powerplant.server.db;

import java.util.Date;

public class ReleveDb {
    private Integer id;

    private Integer plantId;

    private Integer userId;

    private Date timestamp;

    private Long indexCompteur;

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getIndexCompteur() {
        return indexCompteur;
    }

    public void setIndexCompteur(Long indexCompteur) {
        this.indexCompteur = indexCompteur;
    }
}