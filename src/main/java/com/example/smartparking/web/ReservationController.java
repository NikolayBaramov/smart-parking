package com.example.smartparking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

    @GetMapping("/parking/reservation")
    public String getReserveParking(){
        return "reserve-parking";
    }

}
