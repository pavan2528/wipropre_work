package com.wipro.letsgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.letsgo.entity.VehicleMovement;

public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Long> {
}
