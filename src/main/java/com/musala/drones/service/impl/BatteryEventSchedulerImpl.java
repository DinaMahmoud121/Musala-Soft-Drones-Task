package com.musala.drones.service.impl;

import com.musala.drones.model.BatteryEventLogs;
import com.musala.drones.model.Drone;
import com.musala.drones.repository.BatteryEventLogRepository;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.service.BatteryEventScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BatteryEventSchedulerImpl implements BatteryEventScheduler {

	@Autowired
	private BatteryEventLogRepository eventLogRepo;

	@Autowired
	private DroneRepository droneRepo;

	@Override
	@Scheduled(fixedRate = 20000)
	public void eventLogsScheduler() {
		List<Drone> droneList = droneRepo.findAll();
		droneList.forEach(drone -> {
			BatteryEventLogs eventLogs = new BatteryEventLogs();
			eventLogs.setSerialNumber(drone.getSerialNumber());
			eventLogs.setBatteryLevel(drone.getBatteryCapacity());
			eventLogs.setUpdatedTime(new Date().toString());

			log.info("event logs: serialNumber=" + drone.getSerialNumber() + " batteryCapacity="
					+ drone.getBatteryCapacity() + " date: " + new Date());
			eventLogRepo.save(eventLogs);

		});
	}

	@Override
	public List<BatteryEventLogs> getBatteryEventLogs() {
		return eventLogRepo.findAll();
	}

}
