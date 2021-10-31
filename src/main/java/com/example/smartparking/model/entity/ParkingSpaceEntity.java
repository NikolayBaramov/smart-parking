package com.example.smartparking.model.entity;

import com.example.smartparking.model.enums.ParkingSpaceFloorEnum;
import com.example.smartparking.model.enums.ParkingSpaceNumberEnum;

import javax.persistence.*;

@Entity
@Table(name = "parking_space")
public class ParkingSpaceEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name ="parking_space_floor", nullable = false)
    private ParkingSpaceFloorEnum parkingSpaceFloorEnum;

    @Enumerated(EnumType.STRING)
    @Column (name = "parking_space_number",nullable = false)
    private ParkingSpaceNumberEnum parkingSpaceNumberEnum;

    @ManyToOne
    private VehicleTypeEntity vehicleTypeEntity;

    @Column(name = "occupied")
    private Boolean isOccupied;

    public ParkingSpaceEntity() {
    }


    public ParkingSpaceFloorEnum getParkingSpaceFloorEnum() {
        return parkingSpaceFloorEnum;
    }

    public ParkingSpaceEntity setParkingSpaceFloorEnum(ParkingSpaceFloorEnum parkingSpaceFloorEnum) {
        this.parkingSpaceFloorEnum = parkingSpaceFloorEnum;
        return this;
    }

    public ParkingSpaceNumberEnum getParkingSpaceNumberEnum() {
        return parkingSpaceNumberEnum;
    }

    public ParkingSpaceEntity setParkingSpaceNumberEnum(ParkingSpaceNumberEnum parkingSpaceNumberEnum) {
        this.parkingSpaceNumberEnum = parkingSpaceNumberEnum;
        return this;
    }

    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public ParkingSpaceEntity setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
        return this;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public ParkingSpaceEntity setOccupied(Boolean occupied) {
        isOccupied = occupied;
        return this;
    }
}
