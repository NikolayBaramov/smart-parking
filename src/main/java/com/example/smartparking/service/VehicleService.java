package com.example.smartparking.service;


import com.example.smartparking.model.binding.VehicleAddBindingModel;
import com.example.smartparking.model.service.VehicleAddServiceModel;

import java.io.IOException;

public interface VehicleService {

VehicleAddServiceModel addVehicle(VehicleAddBindingModel vehicleAddBindingModel, String ownerId) throws IOException;

}
