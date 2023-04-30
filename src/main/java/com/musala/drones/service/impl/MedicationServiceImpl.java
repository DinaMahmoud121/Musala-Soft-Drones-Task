package com.musala.drones.service.impl;

import com.musala.drones.dto.MedicationDTO;
import com.musala.drones.model.Medication;
import com.musala.drones.repository.MedicationRepository;
import com.musala.drones.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public List<MedicationDTO> getAllMedications() {

        List<Medication> medications = medicationRepository.findAll();

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

}
