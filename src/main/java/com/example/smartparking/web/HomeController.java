package com.example.smartparking.web;

import com.example.smartparking.service.ParkingSpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ParkingSpaceService parkingSpaceService;

    public HomeController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("/availability")
    public String getAvailability(Model model) {
        model.addAttribute("freeCarSpaces",
                parkingSpaceService.freeCarParkingSpaces());
        model.addAttribute("freeElCarSpaces",
                parkingSpaceService.freeElCarParkingSpaces());
        model.addAttribute("freeMotorcycleSpaces",
                parkingSpaceService.freeMotorcycleParkingSpaces());
        return "availability";
    }

}
