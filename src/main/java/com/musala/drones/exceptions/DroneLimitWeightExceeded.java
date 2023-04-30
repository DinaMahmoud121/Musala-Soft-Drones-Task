package com.musala.drones.exceptions;

import com.musala.drones.constants.DroneErrorMessages;

public class DroneLimitWeightExceeded extends Exception {

    public DroneLimitWeightExceeded() {
        super(DroneErrorMessages.LIMIT_WEIGHT_EXCEEDED);
    }

}
