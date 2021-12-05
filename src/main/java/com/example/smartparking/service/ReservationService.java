package com.example.smartparking.service;

import com.example.smartparking.model.binding.ReservationAddBindingModel;
import com.example.smartparking.model.service.ReservationAddServiceModel;
import com.example.smartparking.view.ReservationSummaryView;
import com.example.smartparking.view.VehicleSummaryView;

import java.util.List;

public interface ReservationService {

    ReservationAddServiceModel
    addReservation(ReservationAddBindingModel reservationAddBindingModel, String username);

    List<ReservationSummaryView> getAllOwnReservations(String username);

    List<ReservationSummaryView> getAllReservations();


}
