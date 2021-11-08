package com.example.smartparking.init;

import com.example.smartparking.service.ParkingSpaceService;
import com.example.smartparking.service.UserService;
import com.example.smartparking.service.VehicleTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ParkingSpaceService parkingSpaceService;
    private final VehicleTypeService vehicleTypeService;
    private final UserService userService;

    public DatabaseInit(ParkingSpaceService parkingSpaceService,
                        VehicleTypeService vehicleTypeService,
                        UserService userService) {
        this.parkingSpaceService = parkingSpaceService;
        this.vehicleTypeService = vehicleTypeService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        vehicleTypeService.initializeVehicleTypes();
        parkingSpaceService.initializeParkingSpaces();
        userService.initializeUsersAndRoles();
    }
}
