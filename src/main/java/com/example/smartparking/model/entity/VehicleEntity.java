package com.example.smartparking.model.entity;

import com.example.smartparking.model.enums.VehicleTypeEnum;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class VehicleEntity extends BaseEntity {

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private VehicleTypeEntity vehicleTypeEntity;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String brand;

    @OneToOne
    private PictureEntity pictureEntity;

    @ManyToOne
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private UserEntity owner;


    @OneToMany(mappedBy = "vehicle")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<ReservationEntity> reservationEntities;


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

    public PictureEntity getPictureEntity() {
        return pictureEntity;
    }

    public VehicleEntity setPictureEntity(PictureEntity pictureEntity) {
        this.pictureEntity = pictureEntity;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public VehicleEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public List<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public VehicleEntity setReservationEntities(List<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
        return this;
    }
}
