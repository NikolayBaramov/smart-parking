package com.example.smartparking.repository;

import com.example.smartparking.model.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    List<VehicleEntity> findVehicleEntityByOwnerUsername(String owner_username);

}
