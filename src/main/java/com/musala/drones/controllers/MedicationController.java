package com.musala.drones.controllers;


import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping(value = "/medication-items", produces = "application/json")
    public ResponseEntity<List<MedicationDTO>> getAllDroneMedicationItems() {
        return ResponseEntity.ok(medicationService.getAllMedications());
    }

}
