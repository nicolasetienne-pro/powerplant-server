package com.net.apps.powerplant.server.db;

public class PlantDb {
    private Integer id;

    private Integer plantTypeId;

    private String name;

    private Long capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlantTypeId() {
        return plantTypeId;
    }

    public void setPlantTypeId(Integer plantTypeId) {
        this.plantTypeId = plantTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}