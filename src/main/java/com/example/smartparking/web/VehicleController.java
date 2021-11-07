package com.example.smartparking.web;

import com.example.smartparking.model.binding.VehicleAddBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
