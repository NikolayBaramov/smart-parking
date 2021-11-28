package com.example.smartparking.service;

import com.example.smartparking.model.binding.ReservationAddBindingModel;
import com.example.smartparking.model.service.ReservationAddServiceModel;

public interface ReservationService {

    ReservationAddServiceModel
    addReservation(ReservationAddBindingModel reservationAddBindingModel, String username);


}
