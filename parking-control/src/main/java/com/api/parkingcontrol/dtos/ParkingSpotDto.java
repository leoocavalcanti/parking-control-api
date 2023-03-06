package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDto {

    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;

    @NotBlank
    private LocalDateTime registrationDate;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String reponsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;

    public ParkingSpotDto(ParkingSpot parkingSpot){

        this.parkingSpotNumber = parkingSpot.getParkingSpotNumber();
        this.licensePlateCar = parkingSpot.getLicensePlateCar();
        this.brandCar = parkingSpot.getBrandCar();
        this.modelCar = parkingSpot.getModelCar();
        this.registrationDate = parkingSpot.getRegistrationDate();
        this.colorCar = parkingSpot.getColorCar();
        this.reponsibleName = parkingSpot.getReponsibleName();
        this.apartment = parkingSpot.getApartment();
        this.block = parkingSpot.getBlock();
    }
}
