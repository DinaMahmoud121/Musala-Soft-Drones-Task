package com.musala.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.musala.drones.constants.enums.Model;
import com.musala.drones.constants.enums.State;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Range;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DroneDTO {

    @JsonProperty
    @NotBlank(message = "Serial Number is mandatory")
    private String serialNumber;

    @JsonProperty
    private Model model;

    @JsonProperty
    @Range(min = 0, max = 500, message = "Weight must be in the range of 0 to 500")
    private double weightLimit;

    @JsonProperty
    @Range(min = 0, max = 100, message = "Battery Capacity must be in the range of 0 to 100")
    private int batteryCapacity;

    @JsonProperty
    private State state;
    @JsonInclude(Include.NON_NULL)
    private List<MedicationDTO> medications;

}
