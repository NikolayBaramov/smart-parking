package com.example.smartparking.view;

import com.example.smartparking.model.entity.PictureEntity;
import com.example.smartparking.model.entity.UserEntity;
import com.example.smartparking.model.entity.VehicleTypeEntity;



public class VehicleSummaryView {

    private Long id;
    private String registrationNumber;
    private VehicleTypeEntity vehicleTypeEntity;
    private Integer year;
    private String brand;
    private PictureEntity pictureEntity;
    private UserEntity owner;

    public VehicleSummaryView() {
    }

    public Long getId() {
        return id;
    }

    public VehicleSummaryView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleSummaryView setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public VehicleSummaryView setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleSummaryView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleSummaryView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public PictureEntity getPictureEntity() {
        return pictureEntity;
    }

    public VehicleSummaryView setPictureEntity(PictureEntity pictureEntity) {
        this.pictureEntity = pictureEntity;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public VehicleSummaryView setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }
}
