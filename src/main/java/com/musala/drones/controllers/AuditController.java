package com.musala.drones.controllers;

import java.util.List;

import com.musala.drones.model.BatteryEventLogs;
import com.musala.drones.service.BatteryEventScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

	@Autowired
	private BatteryEventScheduler batteryEventScheduler;

	@GetMapping(value = "/battery")
	public List<BatteryEventLogs> getBatteryEventLogs() {
		return batteryEventScheduler.getBatteryEventLogs();

	}
}
