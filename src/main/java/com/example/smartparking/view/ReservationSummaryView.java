package com.example.smartparking.view;

import com.example.smartparking.model.entity.ParkingSpaceEntity;
import com.example.smartparking.model.entity.UserEntity;
import com.example.smartparking.model.entity.VehicleEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationSummaryView {

    private Long id;
    private LocalDateTime entryDateTime;
    private LocalDateTime exitDateTime;
    private UserEntity user;
    private VehicleEntity vehicle;
    private ParkingSpaceEntity parkingSpace;
    private String reservationNumber;

    public ReservationSummaryView() {
    }

    public String entryTimeToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
        return entryDateTime.format(formatter);
    }

    public String exitTimeToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
        return exitDateTime.format(formatter);
    }

    public String floorAsNumber() {
        if (parkingSpace.getParkingSpaceFloorEnum().toString().equals("GROUND_FLOOR")) {
            return "0";
        } else
            return "1";
    }

    public Long getId() {
        return id;
    }

    public ReservationSummaryView setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public ReservationSummaryView setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public LocalDateTime getExitDateTime() {
        return exitDateTime;
    }

    public ReservationSummaryView setExitDateTime(LocalDateTime exitDateTime) {
        this.exitDateTime = exitDateTime;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ReservationSummaryView setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public ReservationSummaryView setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public ParkingSpaceEntity getParkingSpace() {
        return parkingSpace;
    }

    public ReservationSummaryView setParkingSpace(ParkingSpaceEntity parkingSpace) {
        this.parkingSpace = parkingSpace;
        return this;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public ReservationSummaryView setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
        return this;
    }
}
