package com.example.smartparking.model.entity;

import com.example.smartparking.model.enums.VehicleTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class VehicleEntity extends BaseEntity {

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @ManyToOne
    private VehicleTypeEntity vehicleTypeEntity;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String brand;

    public VehicleEntity() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleEntity setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public VehicleEntity setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
