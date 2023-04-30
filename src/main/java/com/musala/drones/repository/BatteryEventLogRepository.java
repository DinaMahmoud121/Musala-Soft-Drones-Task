package com.musala.drones.repository;

import com.musala.drones.model.BatteryEventLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryEventLogRepository extends JpaRepository<BatteryEventLogs, Long> {

}
