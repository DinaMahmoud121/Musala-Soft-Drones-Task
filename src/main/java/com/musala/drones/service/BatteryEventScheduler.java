package com.musala.drones.service;

import java.util.List;

import com.musala.drones.model.BatteryEventLogs;

public interface BatteryEventScheduler {

	void eventLogsScheduler();

	List<BatteryEventLogs> getBatteryEventLogs();

}
