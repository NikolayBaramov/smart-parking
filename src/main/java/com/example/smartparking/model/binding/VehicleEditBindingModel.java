package com.example.smartparking.model.binding;

import com.example.smartparking.model.enums.VehicleTypeEnum;
import org.springframework.web.multipart.MultipartFile;

public class VehicleEditBindingModel {

    private Long id;

    private String registrationNumber;

    private VehicleTypeEnum vehicleTypeEnum;

    private Integer year;

    private String brand;

    private MultipartFile picture;

    public VehicleEditBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public VehicleEditBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleEditBindingModel setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public VehicleEditBindingModel setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleEditBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleEditBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public VehicleEditBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
