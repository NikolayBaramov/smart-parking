package com.example.smartparking.model.service;

import com.example.smartparking.model.entity.VehicleTypeEntity;

public class VehicleAddServiceModel {

    private Long id;

    private String registrationNumber;

    private VehicleTypeEntity vehicleTypeEntity;

    private Integer year;

    private String brand;

    public VehicleAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public VehicleAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleAddServiceModel setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public VehicleAddServiceModel setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleAddServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
