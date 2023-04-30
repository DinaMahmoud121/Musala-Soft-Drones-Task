package com.musala.drones.repository;


import com.musala.drones.constants.enums.State;
import com.musala.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByState(State state);

    Optional<Drone> findBySerialNumber(String serialNumber);

}
