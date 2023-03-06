package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.services.exceptions.DatabaseException;
import com.api.parkingcontrol.services.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingSpotService {

     @Autowired
     ParkingSpotRepository parkingSpotRepository;

     @Transactional
    public ParkingSpot save(ParkingSpotDto parkingSpotDto) {

         try {
             ParkingSpot parkingSpot = new ParkingSpot();
             BeanUtils.copyProperties(parkingSpotDto, parkingSpot);
             parkingSpot.setRegistrationDate(LocalDate.now(ZoneId.of("UTC")));
             parkingSpotRepository.save(parkingSpot);
             return parkingSpot;
         }
         catch(DataIntegrityViolationException e){

             throw new DatabaseException("[ERRO]: Não pode ser inserido elementos com atributos duplicados.");
         }
    }

    public ParkingSpotDto findById(Long id) {

         Optional<ParkingSpot> parkingSpot = parkingSpotRepository.findById(id);
         parkingSpot.orElseThrow(() -> new NotFoundException("[ERRO]: Entidade não encontrada!"));
         ParkingSpotDto parkingSpotDto = new ParkingSpotDto();
         BeanUtils.copyProperties(parkingSpot.get(), parkingSpotDto);
         return parkingSpotDto;
    }

    public Page<ParkingSpotDto> findAll(Pageable pageable) {

         Page<ParkingSpot> parkingSpots = parkingSpotRepository.findAll(pageable);
         List<ParkingSpotDto> dtos = parkingSpots.stream().map((parkingSpot) -> new ParkingSpotDto(parkingSpot)).collect(Collectors.toList());
         Page<ParkingSpotDto> pageDtos = PageableExecutionUtils.getPage(dtos, pageable, () -> dtos.size());
         return pageDtos;
    }

    public ParkingSpotDto put(Long id, ParkingSpotDto dto) {

         Optional<ParkingSpot> parkingSpot = parkingSpotRepository.findById(id);
        parkingSpot.orElseThrow(() -> new NotFoundException("[ERRO]: Entidade não encontrada!"));
        BeanUtils.copyProperties(dto, parkingSpot.get());
        parkingSpotRepository.save(parkingSpot.get());
        return dto;
    }

    public void deleteById(Long id) {

        Optional<ParkingSpot> parkingSpot = parkingSpotRepository.findById(id);
        parkingSpot.orElseThrow(() -> new NotFoundException("[ERRO]: Entidade não encontrada!"));
        parkingSpotRepository.deleteById(id);
    }
}
