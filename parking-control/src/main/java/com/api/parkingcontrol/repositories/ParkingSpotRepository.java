package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
}
