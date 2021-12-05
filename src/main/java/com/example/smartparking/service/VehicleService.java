package com.example.smartparking.service;


import com.example.smartparking.model.binding.VehicleAddBindingModel;
import com.example.smartparking.model.entity.UserEntity;
import com.example.smartparking.model.service.VehicleAddServiceModel;
import com.example.smartparking.view.VehicleSummaryView;

import java.io.IOException;
import java.util.List;

public interface VehicleService {

VehicleAddServiceModel addVehicle(VehicleAddBindingModel vehicleAddBindingModel, String ownerId) throws IOException;

    void deleteVehicle(Long id);

    boolean isOwner(String userName, Long id);

    boolean isAdmin(UserEntity user);

    void deletePicture(String publicId);

    List<VehicleSummaryView> getAllVehicles();

    List<VehicleSummaryView> getAllOwnVehicles(String username);

}
