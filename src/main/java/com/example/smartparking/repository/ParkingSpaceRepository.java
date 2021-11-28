package com.example.smartparking.repository;

import com.example.smartparking.model.entity.ParkingSpaceEntity;
import com.example.smartparking.model.entity.VehicleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, Long> {

    Optional<ParkingSpaceEntity> findFirstByVehicleTypeEntityAndIsOccupiedFalse(VehicleTypeEntity vehicleTypeEntity);


}
