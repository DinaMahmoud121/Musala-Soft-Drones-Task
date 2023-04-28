package com.musala.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicationDTO {

    @JsonProperty
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9_-]*$", message = "Name can only contain letters, numbers, '-', '_'")
    private String name;

    @JsonProperty
    private double weight;

    @JsonProperty
    @Pattern(regexp = "^[A-Z0-9_]*$", message = "Code can only contain capital letters, numbers, '_'")
    private String code;

    @JsonProperty
    @NotBlank(message = "Image is mandatory")
    private String image;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DroneDTO drone;

}
