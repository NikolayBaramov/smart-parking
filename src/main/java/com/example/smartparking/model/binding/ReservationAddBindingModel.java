package com.example.smartparking.model.binding;

import com.example.smartparking.model.entity.VehicleEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.Instant;

public class ReservationAddBindingModel {

    private Long id;

    private Long vehicleId;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Instant entryDateTime;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Instant exitDateTime;

    public ReservationAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public ReservationAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public ReservationAddBindingModel setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public ReservationAddBindingModel setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public Instant getExitDateTime() {
        return exitDateTime;
    }

    public ReservationAddBindingModel setExitDateTime(Instant exitDateTime) {
        this.exitDateTime = exitDateTime;
        return this;
    }
}
