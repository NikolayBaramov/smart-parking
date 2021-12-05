package com.example.smartparking.service;


import com.example.smartparking.model.entity.ParkingSpaceEntity;
import com.example.smartparking.model.entity.VehicleTypeEntity;

import java.util.List;

public interface ParkingSpaceService {

    void initializeParkingSpaces();

    void setAsOccupied(ParkingSpaceEntity parkingSpace);

    List<ParkingSpaceEntity> findAllFreeParkingSpacesByVehicleType(VehicleTypeEntity vehicleTypeEntity);

    int freeCarParkingSpaces();
    int freeElCarParkingSpaces();
    int freeMotorcycleParkingSpaces();


}
