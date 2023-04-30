package com.musala.drones.exceptions;

import com.musala.drones.constants.DroneErrorMessages;

public class DroneBatteryLow extends Exception {

    public DroneBatteryLow() {
        super(DroneErrorMessages.BATTERY_LOW);
    }

}
