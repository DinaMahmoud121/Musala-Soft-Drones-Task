package com.musala.drones.exceptions;

import com.musala.drones.constants.DroneErrorMessages;

public class DronesLimitReached extends Exception {

    public DronesLimitReached() {
        super(DroneErrorMessages.LIMIT_REACHED);
    }

}
