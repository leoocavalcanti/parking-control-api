package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    @Autowired
    private ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpot> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){

        ParkingSpot entity = parkingSpotService.save(parkingSpotDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpotDto>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<ParkingSpotDto> entity = parkingSpotService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotDto> getOneParkingSpot(@PathVariable Long id){

        ParkingSpotDto entity = parkingSpotService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpotDto> putParkingSpot(@PathVariable Long id, @RequestBody ParkingSpotDto dto){

        ParkingSpotDto entity = parkingSpotService.put(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingSpotDto> deleteParkingSpot(@PathVariable Long id){

        parkingSpotService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
