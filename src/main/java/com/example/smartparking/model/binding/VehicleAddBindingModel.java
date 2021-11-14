package com.example.smartparking.model.binding;

import com.example.smartparking.model.enums.VehicleTypeEnum;
import org.springframework.web.multipart.MultipartFile;

public class VehicleAddBindingModel {

    private String registrationNumber;

    private VehicleTypeEnum vehicleTypeEnum;

    private Integer year;

    private String brand;

    private MultipartFile picture;

    public VehicleAddBindingModel() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleAddBindingModel setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public VehicleAddBindingModel setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleAddBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public VehicleAddBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
