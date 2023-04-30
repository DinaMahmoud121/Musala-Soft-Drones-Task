package com.musala.drones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BATTERY_EVENT_LOGS")
@Data
@NoArgsConstructor
public class BatteryEventLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialNumber;

    private String updatedTime;

    private double batteryLevel;

}
