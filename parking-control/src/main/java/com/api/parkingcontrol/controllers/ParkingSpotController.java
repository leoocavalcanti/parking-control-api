package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    @Autowired
    private ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpotDto> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){

        ParkingSpotDto dto = parkingSpotService.save(parkingSpotDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

}
