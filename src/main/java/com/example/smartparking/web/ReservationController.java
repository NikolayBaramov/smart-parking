package com.example.smartparking.web;

import com.example.smartparking.model.binding.ReservationAddBindingModel;
import com.example.smartparking.model.service.ReservationAddServiceModel;
import com.example.smartparking.service.ReservationService;
import com.example.smartparking.service.VehicleService;
import com.example.smartparking.service.impl.SmartParkingUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ReservationController {

    private final VehicleService vehicleService;
    private final ModelMapper modelMapper;
    private final ReservationService reservationService;

    public ReservationController(VehicleService vehicleService,
                                 ModelMapper modelMapper,
                                 ReservationService reservationService) {
        this.vehicleService = vehicleService;
        this.modelMapper = modelMapper;
        this.reservationService = reservationService;
    }

    @GetMapping("/parking/reservation")
    public String getReserveParking(Model model, @AuthenticationPrincipal SmartParkingUser currentUser) {

        if (!model.containsAttribute("reservationAddBindingModel")) {
            model.
                    addAttribute("reservationAddBindingModel", new ReservationAddBindingModel()).
                    addAttribute("vehicles", vehicleService.getAllOwnVehicles(currentUser.getUsername()));
        }

        return "reserve-parking";
    }

    @PostMapping("/parking/reservation")
    public String addVehicle(@Valid ReservationAddBindingModel reservationAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal SmartParkingUser user) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reservationAddBindingModel", reservationAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.reservationAddBindingModel", bindingResult);
            return "redirect:/parking/reservation";
        }
        ReservationAddServiceModel savedReservationAddServiceModel =
                reservationService.addReservation(reservationAddBindingModel, user.getUserIdentifier());
        return "redirect:/parking/reservation/all";
    }

}
