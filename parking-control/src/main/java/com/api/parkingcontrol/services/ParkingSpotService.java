package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ParkingSpotService {

     @Autowired
     ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotDto save(ParkingSpotDto parkingSpotDto) {

        ParkingSpot parkingSpot = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpot);
        parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        parkingSpotRepository.save(parkingSpot);
        return new ParkingSpotDto(parkingSpot);
    }
}
