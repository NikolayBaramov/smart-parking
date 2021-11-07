package com.example.smartparking.service.impl;

import com.example.smartparking.model.entity.VehicleTypeEntity;
import com.example.smartparking.model.enums.VehicleTypeEnum;
import com.example.smartparking.repository.VehicleTypeRepository;
import com.example.smartparking.service.VehicleTypeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeServiceImpl(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public void initializeVehicleTypes() {

        if (vehicleTypeRepository.count()==0){

            Arrays.stream(VehicleTypeEnum.values())
                    .forEach(vehicleTypeEnum -> {
                        VehicleTypeEntity vehicleType = new VehicleTypeEntity();
                        vehicleType.setVehicleTypeEnum(vehicleTypeEnum);

                        vehicleTypeRepository.save(vehicleType);
                    });
        }

    }

    @Override
    public VehicleTypeEntity findByVehicleTypeEnumeration(VehicleTypeEnum vehicleTypeEnum) {
        return vehicleTypeRepository.findByVehicleTypeEnum(vehicleTypeEnum)
                .orElse(null);
    }
}
