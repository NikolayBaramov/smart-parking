package com.example.smartparking.web;

import com.example.smartparking.service.ParkingSpaceService;
import com.example.smartparking.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ParkingSpaceService parkingSpaceService;
    private final ReservationService reservationService;

    public HomeController(ParkingSpaceService parkingSpaceService,
                          ReservationService reservationService) {
        this.parkingSpaceService = parkingSpaceService;
        this.reservationService = reservationService;
    }

    @GetMapping("/availability")
    public String getAvailability(Model model) {
        reservationService.freeParkingSpacesIfReservationIsExpired();
//        reservationService.freeAllParkingSpaces();

        model.addAttribute("freeCarSpaces",
                parkingSpaceService.freeCarParkingSpaces());
        model.addAttribute("freeElCarSpaces",
                parkingSpaceService.freeElCarParkingSpaces());
        model.addAttribute("freeMotorcycleSpaces",
                parkingSpaceService.freeMotorcycleParkingSpaces());
        return "availability";
    }

    @GetMapping("/help")
        public String getHelp(){
            return "help";
        }


}
