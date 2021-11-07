package com.example.smartparking.init;

import com.example.smartparking.service.ParkingSpaceService;
import com.example.smartparking.service.VehicleTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ParkingSpaceService parkingSpaceService;
    private final VehicleTypeService vehicleTypeService;

    public DatabaseInit(ParkingSpaceService parkingSpaceService,
                        VehicleTypeService vehicleTypeService) {
        this.parkingSpaceService = parkingSpaceService;
        this.vehicleTypeService = vehicleTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        vehicleTypeService.initializeVehicleTypes();
        parkingSpaceService.initializeParkingSpaces();
    }
}
