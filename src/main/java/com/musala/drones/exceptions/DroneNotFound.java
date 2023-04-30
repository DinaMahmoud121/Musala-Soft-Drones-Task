package com.musala.drones.exceptions;

import com.musala.drones.constants.DroneErrorMessages;

public class DroneNotFound extends Exception {

    public DroneNotFound() {
        super(DroneErrorMessages.NOT_FOUND);
    }

}
