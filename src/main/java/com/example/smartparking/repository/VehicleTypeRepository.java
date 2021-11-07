package com.example.smartparking.repository;

import com.example.smartparking.model.entity.VehicleTypeEntity;
import com.example.smartparking.model.enums.VehicleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Long> {

    Optional<VehicleTypeEntity> findByVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum);

}
