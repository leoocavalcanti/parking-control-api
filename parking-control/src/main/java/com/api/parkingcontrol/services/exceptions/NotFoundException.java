package com.api.parkingcontrol.services.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg){

        super(msg);
    }
}
