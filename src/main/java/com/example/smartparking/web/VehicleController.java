package com.example.smartparking.web;

import com.example.smartparking.model.binding.VehicleAddBindingModel;
import com.example.smartparking.service.impl.SmartParkingUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class VehicleController {

    @GetMapping("/vehicle/add")
    public String getAddVehiclePage(Model model) {

        if (!model.containsAttribute("vehicleAddBindingModel")) {
            model.
                    addAttribute("vehicleAddBindingModel", new VehicleAddBindingModel());
        }
        return "add-vehicle";
    }

    @PostMapping("/vehicle/add")
    public String addVehicle(@Valid VehicleAddBindingModel vehicleAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal SmartParkingUser user) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("vehicleAddBindingModel", vehicleAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.vehicleAddBindingModel", bindingResult);
            return "redirect:/vehicle/add";
        }
        // TODO implemen hier
        return "redirect:/vehicle/add";
    }

}
