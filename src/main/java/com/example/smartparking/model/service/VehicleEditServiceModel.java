package com.example.smartparking.model.service;

import com.example.smartparking.model.entity.VehicleTypeEntity;
import org.springframework.web.multipart.MultipartFile;

public class VehicleEditServiceModel {

    private Long id;

    private String registrationNumber;

    private VehicleTypeEntity vehicleTypeEntity;

    private Integer year;

    private String brand;

    private MultipartFile picture;

    public VehicleEditServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public VehicleEditServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleEditServiceModel setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public VehicleEditServiceModel setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleEditServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleEditServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public VehicleEditServiceModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
