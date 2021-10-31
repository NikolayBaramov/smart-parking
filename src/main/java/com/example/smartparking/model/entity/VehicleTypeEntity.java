package com.example.smartparking.model.entity;

import com.example.smartparking.model.enums.VehicleTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_types")
public class VehicleTypeEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type_name", nullable = false)
    private VehicleTypeEnum vehicleTypeEnum;

    public VehicleTypeEntity() {
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public VehicleTypeEntity setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
        return this;
    }
}
