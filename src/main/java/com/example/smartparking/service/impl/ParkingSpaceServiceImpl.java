package com.example.smartparking.service.impl;

import com.example.smartparking.model.entity.ParkingSpaceEntity;
import com.example.smartparking.model.entity.VehicleTypeEntity;
import com.example.smartparking.model.enums.ParkingSpaceFloorEnum;
import com.example.smartparking.model.enums.ParkingSpaceNumberEnum;
import com.example.smartparking.model.enums.VehicleTypeEnum;
import com.example.smartparking.repository.ParkingSpaceRepository;
import com.example.smartparking.service.ParkingSpaceService;
import com.example.smartparking.service.VehicleTypeService;
import org.springframework.stereotype.Service;


@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;
    private final VehicleTypeService vehicleTypeService;

    public ParkingSpaceServiceImpl(ParkingSpaceRepository parkingSpaceRepository,
                                   VehicleTypeService vehicleTypeService) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleTypeService = vehicleTypeService;
    }


    @Override
    public void initializeParkingSpaces() {
        if (parkingSpaceRepository.count() != 0) {
            return;
        }
            VehicleTypeEntity elCar = vehicleTypeService.findByVehicleTypeEnumeration(VehicleTypeEnum.ELECTRIC_CAR);
            VehicleTypeEntity car = vehicleTypeService.findByVehicleTypeEnumeration(VehicleTypeEnum.CAR);
            VehicleTypeEntity mBike = vehicleTypeService.findByVehicleTypeEnumeration(VehicleTypeEnum.MOTORCYCLE);


            for (int i = 1; i <= 5; i++) {
                ParkingSpaceEntity ei = new ParkingSpaceEntity();
                ei.setOccupied(false).setParkingSpaceFloorEnum(ParkingSpaceFloorEnum.GROUND_FLOOR)
                        .setParkingSpaceNumberEnum(ParkingSpaceNumberEnum.valueOf("E" + i))
                        .setVehicleTypeEntity(elCar);

                parkingSpaceRepository.save(ei);
            }

            for (int i = 6; i <= 10; i++) {
                ParkingSpaceEntity ei = new ParkingSpaceEntity();
                ei.setOccupied(false).setParkingSpaceFloorEnum(ParkingSpaceFloorEnum.FIRST_FLOOR)
                        .setParkingSpaceNumberEnum(ParkingSpaceNumberEnum.valueOf("E" + i))
                        .setVehicleTypeEntity(elCar);

                parkingSpaceRepository.save(ei);
            }

            for (int i = 1; i <= 5; i++) {
                ParkingSpaceEntity mi = new ParkingSpaceEntity();
                mi.setOccupied(false).setParkingSpaceFloorEnum(ParkingSpaceFloorEnum.GROUND_FLOOR)
                        .setParkingSpaceNumberEnum(ParkingSpaceNumberEnum.valueOf("M" + i))
                        .setVehicleTypeEntity(mBike);

                parkingSpaceRepository.save(mi);
            }

            for (int i = 1; i <= 10; i++) {
                ParkingSpaceEntity ci = new ParkingSpaceEntity();
                ci.setOccupied(false).setParkingSpaceFloorEnum(ParkingSpaceFloorEnum.GROUND_FLOOR)
                        .setParkingSpaceNumberEnum(ParkingSpaceNumberEnum.valueOf("C" + i))
                        .setVehicleTypeEntity(car);

                parkingSpaceRepository.save(ci);
            }

            for (int i = 11; i <= 20; i++) {
                ParkingSpaceEntity ci = new ParkingSpaceEntity();
                ci.setOccupied(false).setParkingSpaceFloorEnum(ParkingSpaceFloorEnum.FIRST_FLOOR)
                        .setParkingSpaceNumberEnum(ParkingSpaceNumberEnum.valueOf("C" + i))
                        .setVehicleTypeEntity(car);

                parkingSpaceRepository.save(ci);
            }

    }

}
