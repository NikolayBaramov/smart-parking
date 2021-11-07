package com.example.smartparking.repository;

import com.example.smartparking.model.entity.ParkingSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, Long> {


}
