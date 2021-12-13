package com.example.smartparking.service.impl;

import com.example.smartparking.model.binding.ReservationAddBindingModel;
import com.example.smartparking.model.entity.*;
import com.example.smartparking.model.service.ReservationAddServiceModel;
import com.example.smartparking.repository.ParkingSpaceRepository;
import com.example.smartparking.repository.ReservationRepository;
import com.example.smartparking.repository.UserRepository;
import com.example.smartparking.repository.VehicleRepository;
import com.example.smartparking.service.ReservationService;
import com.example.smartparking.view.ReservationSummaryView;
import com.example.smartparking.view.VehicleSummaryView;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final ParkingSpaceServiceImpl parkingSpaceService;
    private final VehicleServiceImpl vehicleServiceImpl;


    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ModelMapper modelMapper,
                                  VehicleRepository vehicleRepository,
                                  UserRepository userRepository,
                                  ParkingSpaceRepository parkingSpaceRepository,
                                  ParkingSpaceServiceImpl parkingSpaceService,
                                  VehicleServiceImpl vehicleServiceImpl) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.parkingSpaceService = parkingSpaceService;
        this.vehicleServiceImpl = vehicleServiceImpl;
    }

    @Override
    public ReservationAddServiceModel
    addReservation(ReservationAddBindingModel reservationAddBindingModel, String username) {
        UserEntity currentUser = userRepository.findByUsername(username).orElseThrow();
        ReservationAddServiceModel reservationAddServiceModel =
                modelMapper.map(reservationAddBindingModel, ReservationAddServiceModel.class);
        ReservationEntity newReservation = modelMapper.map(reservationAddServiceModel, ReservationEntity.class);
        newReservation.setUser(currentUser);
        VehicleEntity chosenVehicle = this.vehicleRepository
                .findById(reservationAddBindingModel.getVehicleId()).orElseThrow();
        newReservation.setVehicle(chosenVehicle);
        VehicleTypeEntity currentVehicleType = chosenVehicle.getVehicleTypeEntity();
        ParkingSpaceEntity currentParkingSpace =
                parkingSpaceRepository.findFirstByVehicleTypeEntityAndIsOccupiedFalse(currentVehicleType)
                        .orElseThrow(null);
        parkingSpaceService.setAsOccupied(currentParkingSpace);
        newReservation.setParkingSpace(currentParkingSpace);
        newReservation.setReservationNumber("rn-" + newReservation.getId());

        ReservationEntity savedReservation = reservationRepository.save(newReservation);
        newReservation.setReservationNumber("RN-" + newReservation.getId());
        reservationRepository.save(newReservation);
        // hear I update the reservationNumber in the repository

        return modelMapper.map(savedReservation, ReservationAddServiceModel.class);
    }

    @Override
    public List<ReservationSummaryView> getAllReservations() {
        return reservationRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }


    @Override
    public List<ReservationSummaryView> getAllOwnReservations(String username) {
        Optional<UserEntity> caller = userRepository.findByUsername(username);
        if (caller.isEmpty()) {
            return null;
        } else if (vehicleServiceImpl.isAdmin(caller.get())) {
            return getAllReservations();
        } else {
            return reservationRepository
                    .findReservationEntityByUserUsername(username)
                    .stream().
                    map(this::map).
                    collect(Collectors.toList());
        }
    }

    private ReservationSummaryView map(ReservationEntity reservationEntity) {

        return this.modelMapper
                .map(reservationEntity, ReservationSummaryView.class);

    }

    @Override
    public void freeParkingSpacesIfReservationIsExpired() {
        List<ReservationEntity> expiredReservations =
                reservationRepository.findAllByExitDateTimeIsBefore(LocalDateTime.now());
        expiredReservations
                .forEach(reservationEntity -> {
                    ParkingSpaceEntity parkingSpace = reservationEntity.getParkingSpace();
                    parkingSpace.setOccupied(false);
                    parkingSpaceRepository.save(parkingSpace);
                });
    }



}
