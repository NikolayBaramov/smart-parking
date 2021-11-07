package com.example.smartparking.service;


import com.example.smartparking.model.entity.VehicleTypeEntity;
import com.example.smartparking.model.enums.VehicleTypeEnum;

public interface VehicleTypeService {

    void initializeVehicleTypes();

    VehicleTypeEntity findByVehicleTypeEnumeration(VehicleTypeEnum vehicleTypeEnum);

}
