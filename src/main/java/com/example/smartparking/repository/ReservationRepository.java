package com.example.smartparking.repository;

import com.example.smartparking.model.entity.ReservationEntity;
import com.example.smartparking.model.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findReservationEntityByUserUsername(String user_username);

    List<ReservationEntity> findAllByExitDateTimeIsBefore(LocalDateTime time);

}
