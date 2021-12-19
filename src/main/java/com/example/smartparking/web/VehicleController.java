package com.example.smartparking.web;

import com.example.smartparking.model.binding.VehicleAddBindingModel;
import com.example.smartparking.model.binding.VehicleEditBindingModel;
import com.example.smartparking.model.enums.VehicleTypeEnum;
import com.example.smartparking.model.service.VehicleAddServiceModel;
import com.example.smartparking.service.VehicleService;
import com.example.smartparking.service.impl.SmartParkingUser;
import com.example.smartparking.view.VehicleSummaryView;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;
    private final ModelMapper modelMapper;

    public VehicleController(VehicleService vehicleService,
                             ModelMapper modelMapper) {
        this.vehicleService = vehicleService;
        this.modelMapper = modelMapper;
    }

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
                             @AuthenticationPrincipal SmartParkingUser user) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("vehicleAddBindingModel", vehicleAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.vehicleAddBindingModel", bindingResult);
            return "redirect:/vehicle/add";
        }
        VehicleAddServiceModel savedVehicleAddServiceModel =
                vehicleService.addVehicle(vehicleAddBindingModel, user.getUserIdentifier());
        return "redirect:/vehicle/all";
    }

    //DELETE
    @PreAuthorize("@vehicleServiceImpl.isOwner(#principal.name,#id)")
    @Transactional
    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable Long id, Principal principal,
                                @RequestParam("public_id") String publicId) {

        vehicleService.deleteVehicle(id);
        vehicleService.deletePicture(publicId);

        return "redirect:/";
    }


    // GET
    @GetMapping("/vehicle/all")
    public String allVehicle(Model model, @AuthenticationPrincipal SmartParkingUser currentUser) {
        model.addAttribute("vehicles",
                vehicleService.getAllOwnVehicles(currentUser.getUsername()));
        return "vehicles";
    }

    // EDIT
    @GetMapping("/vehicle/{id}/edit")
    public String editVehicle(@PathVariable Long id, Model model,
                              @AuthenticationPrincipal SmartParkingUser currentUser){

        VehicleSummaryView vehicleSummaryView = vehicleService.findById(id,currentUser.getUserIdentifier());
        VehicleEditBindingModel vehicleEditBindingModel = modelMapper
                .map(vehicleSummaryView,VehicleEditBindingModel.class);

        model.addAttribute("vehicleTypes", VehicleTypeEnum.values());
        model.addAttribute("vehicleEditBindingModel", vehicleEditBindingModel);

        return "edit-vehicle";
    }

}
