package com.example.smartparking.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity extends BaseEntity {

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(name = "exit_date", nullable = false)
    private LocalDate exitDate;

    @Column(name = "entry_time", nullable = false)
    private LocalDateTime entryTime;

    @Column (name = "exit_time", nullable = false)
    private LocalDateTime exitTime;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private VehicleEntity vehicle;

    @ManyToOne
    private ParkingSpaceEntity parkingSpace;

    private Long ReservationNumber;

    public ReservationEntity() {
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public ReservationEntity setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
        return this;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public ReservationEntity setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
        return this;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ReservationEntity setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public ReservationEntity setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
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
