package com.musala.drones.service.impl;

import com.musala.drones.constants.enums.Model;
import com.musala.drones.constants.enums.State;
import com.musala.drones.dto.DroneDTO;
import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.exceptions.*;
import com.musala.drones.model.Drone;
import com.musala.drones.model.Medication;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.repository.MedicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class DroneServiceImplTest {
    @Mock
    DroneRepository droneRepository;
    @Mock
    MedicationRepository medicationRepository;
    @InjectMocks
    DroneServiceImpl droneServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterDrone() {
        DroneDTO result = droneServiceImpl.registerDrone(droneDTO());
        Assertions.assertEquals(droneDTO(), result);
    }

    @Test
    void testLoadMedicationToDrone() {
        when(droneRepository.findBySerialNumber(anyString())).thenReturn(Optional.of(drone()));
        when(medicationRepository.findByDroneId(anyLong())).thenReturn(List.of(medication()));

        Assertions.assertThrows(DroneBatteryLow.class, () -> droneServiceImpl.loadMedicationToDrone("serialNumber", medicationDTO()));
    }

    @Test
    void testGetAllAvailableDrones() {
        when(droneRepository.findByState(any())).thenReturn(List.of(drone()));

        List<DroneDTO> result = droneServiceImpl.getAllAvailableDrones();
        Assertions.assertEquals(List.of(droneDTO()), result);
    }

    @Test
    void testGetDroneBySerialNumber() throws DroneNotFound {
        when(droneRepository.findBySerialNumber(anyString())).thenReturn(Optional.of(drone()));

        DroneDTO result = droneServiceImpl.getDroneBySerialNumber("serialNumber");
        Assertions.assertEquals(droneDTO(), result);
    }

    private Drone drone() {
        return new Drone(1L, "serialNumber", Model.Lightweight, 0d, 0, State.IDLE, List.of(medication()));
    }

    private Medication medication() {
        return new Medication("name", 0d, "code", "image");
    }

    private DroneDTO droneDTO() {
        return new DroneDTO("serialNumber", Model.Lightweight, 0d, 0, State.IDLE, List.of(medicationDTO()));
    }

    private MedicationDTO medicationDTO() {
        return new MedicationDTO("name", 0d, "code", "image", null);
    }
}