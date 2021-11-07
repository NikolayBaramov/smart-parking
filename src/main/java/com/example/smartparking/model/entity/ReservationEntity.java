package com.example.smartparking.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity extends BaseEntity {

    @Column(name = "entry_date_time", nullable = false)
    private Instant entryDateTime;

    @Column(name = "exit_date_time", nullable = false)
    private Instant exitDateTime;


    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private VehicleEntity vehicle;

    @ManyToOne
    private ParkingSpaceEntity parkingSpace;

    private Long ReservationNumber;

    public ReservationEntity() {
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public ReservationEntity setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public Instant getExitDateTime() {
        return exitDateTime;
    }

    public ReservationEntity setExitDateTime(Instant exitDateTime) {
        this.exitDateTime = exitDateTime;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ReservationEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public ReservationEntity setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public ParkingSpaceEntity getParkingSpace() {
        return parkingSpace;
    }

    public ReservationEntity setParkingSpace(ParkingSpaceEntity parkingSpace) {
        this.parkingSpace = parkingSpace;
        return this;
    }

    public Long getReservationNumber() {
        return ReservationNumber;
    }

    public ReservationEntity setReservationNumber(Long reservationNumber) {
        ReservationNumber = reservationNumber;
        return this;
    }
}
