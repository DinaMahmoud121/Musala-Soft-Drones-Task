package com.musala.drones.repository;

import com.musala.drones.constants.enums.State;
import com.musala.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByState(State state);

    Optional<Drone> findBySerialNumber(String serialNumber);

}
