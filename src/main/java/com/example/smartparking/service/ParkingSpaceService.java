package com.example.smartparking.service;


import com.example.smartparking.model.entity.ParkingSpaceEntity;

public interface ParkingSpaceService {

    void initializeParkingSpaces();

    void setAsOccupied(ParkingSpaceEntity parkingSpace);


}
