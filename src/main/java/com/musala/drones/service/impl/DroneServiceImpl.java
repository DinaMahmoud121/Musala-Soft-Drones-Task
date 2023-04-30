package com.musala.drones.service.impl;

import com.musala.drones.constants.enums.State;
import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.exceptions.*;
import com.musala.drones.model.Drone;
import com.musala.drones.model.Medication;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.repository.MedicationRepository;
import com.musala.drones.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;


    @Override
    public DroneDTO registerDrone(DroneDTO droneDTO) {
        Drone drone = new Drone(
                droneDTO.getSerialNumber(),
                droneDTO.getModel(),
                droneDTO.getWeightLimit(),
                droneDTO.getBatteryCapacity(),
                State.IDLE);
        droneRepository.save(drone);
        return droneDTO;
    }

    @Override
    public MedicationDTO loadMedicationToDrone(String serialNumber, MedicationDTO medicationDTO) throws DroneNotFound, DroneBatteryLow, DroneBlockLoading, DroneLimitWeightExceeded {
        Drone drone = validateDroneLoading(serialNumber, medicationDTO);
        if (drone.getState().equals(State.IDLE)) {
            drone.setState(State.LOADING);
            droneRepository.save(drone);
        }

        Medication medication = new Medication(
                medicationDTO.getName(),
                medicationDTO.getWeight(),
                medicationDTO.getCode(),
                medicationDTO.getImage());
        medication.setDrone(drone);
        medicationRepository.save(medication);
        medicationDTO.setDrone(DroneDTO.builder()
                .serialNumber(drone.getSerialNumber())
                .model(drone.getModel())
                .weightLimit(drone.getWeightLimit())
                .state(drone.getState())
                .batteryCapacity(drone.getBatteryCapacity())
                .medications(this.mapMedicationToMedicationDTO(drone.getMedications()))
                .build());
        return medicationDTO;
    }

    private Drone validateDroneLoading(String serialNumber, MedicationDTO medicationDTO) throws DroneNotFound, DroneBatteryLow, DroneBlockLoading, DroneLimitWeightExceeded {
        Optional<Drone> optionalDrone = droneRepository.findBySerialNumber(serialNumber);
        if (optionalDrone.isEmpty()) {
            throw new DroneNotFound();
        }
        Drone drone = optionalDrone.get();
        if (!drone.getState().equals(State.IDLE) && !drone.getState().equals(State.LOADING)) {
            throw new DroneBlockLoading();
        }
        if (drone.getBatteryCapacity() < 25) {
            throw new DroneBatteryLow();
        }
        List<Medication> medications = this.getMedicationsByDroneId(drone.getId());

        double totalWeight = medications.stream().mapToDouble(Medication::getWeight).sum();

        if (totalWeight + medicationDTO.getWeight() > drone.getWeightLimit()) {
            throw new DroneLimitWeightExceeded();
        }
        return drone;
    }

    private List<Medication> getMedicationsByDroneId(long id) {
        return medicationRepository.findByDroneId(id);
    }

    @Override
    public List<DroneDTO> getAllAvailableDrones() {
        List<Drone> idleDrones = droneRepository.findByState(State.IDLE);
        List<DroneDTO> results = new ArrayList<>();
        idleDrones.forEach(drone -> results.add(DroneDTO.builder()
                .serialNumber(drone.getSerialNumber())
                .model(drone.getModel())
                .weightLimit(drone.getWeightLimit())
                .state(drone.getState())
                .batteryCapacity(drone.getBatteryCapacity())
                .medications(this.mapMedicationToMedicationDTO(drone.getMedications()))
                .build()));
        return results;
    }


    private List<MedicationDTO> mapMedicationToMedicationDTO(List<Medication> medications) {

        List<MedicationDTO> medicationDTOList = new ArrayList<>();
        medications.forEach(medication ->
                medicationDTOList.add(MedicationDTO.builder()
                        .name(medication.getName())
                        .code(medication.getCode())
                        .weight(medication.getWeight())
                        .image(medication.getImage())
                        .build()));
        return medicationDTOList;

    }

    @Override
    public DroneDTO getDroneBySerialNumber(String serialNumber) throws DroneNotFound {
        Optional<Drone> droneOptional = droneRepository.findBySerialNumber(serialNumber);
        if (droneOptional.isEmpty()) {
            throw new DroneNotFound();
        }
        Drone drone = droneOptional.get();

        return DroneDTO.builder()
                .serialNumber(drone.getSerialNumber())
                .model(drone.getModel())
                .weightLimit(drone.getWeightLimit())
                .weightLimit(drone.getWeightLimit())
                .state(State.IDLE)
                .batteryCapacity(drone.getBatteryCapacity())
                .medications(this.mapMedicationToMedicationDTO(drone.getMedications()))
                .build();
    }

}

