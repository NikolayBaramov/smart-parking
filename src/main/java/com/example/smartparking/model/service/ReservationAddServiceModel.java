package com.example.smartparking.model.service;

import com.example.smartparking.model.entity.ParkingSpaceEntity;

import java.time.Instant;

public class ReservationAddServiceModel {

    private Long id;
    private Long vehicleId;
    private Instant entryDateTime;
    private Instant exitDateTime;
    private ParkingSpaceEntity parkingSpace;

    public ReservationAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ReservationAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public ReservationAddServiceModel setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public ReservationAddServiceModel setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public Instant getExitDateTime() {
        return exitDateTime;
    }

    public ReservationAddServiceModel setExitDateTime(Instant exitDateTime) {
        this.exitDateTime = exitDateTime;
        return this;
    }

    public ParkingSpaceEntity getParkingSpace() {
        return parkingSpace;
    }

    public ReservationAddServiceModel setParkingSpace(ParkingSpaceEntity parkingSpace) {
        this.parkingSpace = parkingSpace;
        return this;
    }
}
