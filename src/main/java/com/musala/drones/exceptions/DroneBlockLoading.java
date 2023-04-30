package com.musala.drones.exceptions;


import com.musala.drones.constants.DroneErrorMessages;

public class DroneBlockLoading extends Exception {

    public DroneBlockLoading() {
        super(DroneErrorMessages.BLOCKED_LOADING);
    }

}
