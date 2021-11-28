package com.example.smartparking.service.impl;

import com.example.smartparking.model.binding.ReservationAddBindingModel;
import com.example.smartparking.model.entity.*;
import com.example.smartparking.model.service.ReservationAddServiceModel;
import com.example.smartparking.repository.ParkingSpaceRepository;
import com.example.smartparking.repository.ReservationRepository;
import com.example.smartparking.repository.UserRepository;
import com.example.smartparking.repository.VehicleRepository;
import com.example.smartparking.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final ParkingSpaceServiceImpl parkingSpaceService;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ModelMapper modelMapper,
                                  VehicleRepository vehicleRepository,
                                  UserRepository userRepository,
                                  ParkingSpaceRepository parkingSpaceRepository,
                                  ParkingSpaceServiceImpl parkingSpaceService) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.parkingSpaceService = parkingSpaceService;
    }

    @Override
    public ReservationAddServiceModel
    addReservation(ReservationAddBindingModel reservationAddBindingModel, String username) {
        UserEntity currentUser = userRepository.findByUsername(username).orElseThrow();
        ReservationAddServiceModel reservationAddServiceModel =
                modelMapper.map(reservationAddBindingModel, ReservationAddServiceModel.class);
        ReservationEntity newReservation = modelMapper.map(reservationAddServiceModel, ReservationEntity.class);
        newReservation.setUser(currentUser);
        VehicleEntity chosenVehicle = vehicleRepository.getById(reservationAddBindingModel.getVehicleId());
        newReservation.setVehicle(chosenVehicle);
        VehicleTypeEntity currentVehicleType = chosenVehicle.getVehicleTypeEntity();
        ParkingSpaceEntity currentParkingSpace =
                parkingSpaceRepository.findFirstByVehicleTypeEntityAndIsOccupiedFalse(currentVehicleType)
                        .orElseThrow(null);
        parkingSpaceService.setAsOccupied(currentParkingSpace);

        ReservationEntity savedReservation = reservationRepository.save(newReservation);
        return modelMapper.map(savedReservation, ReservationAddServiceModel.class);
    }
}
