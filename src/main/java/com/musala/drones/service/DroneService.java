package com.musala.drones.service;

import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.exceptions.*;

import java.util.List;

public interface DroneService {

	DroneDTO registerDrone(DroneDTO newDrone);

	List<DroneDTO> getAllAvailableDrones();

	MedicationDTO loadMedicationToDrone(String serialNumber, MedicationDTO medicationDTO) throws DroneNotFound, DroneBatteryLow, DroneBlockLoading, DroneLimitWeightExceeded;

	DroneDTO getDroneBySerialNumber(String serialNumber) throws DroneNotFound;
}
