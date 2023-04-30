package com.musala.drones.model;

import com.musala.drones.constants.enums.Model;
import com.musala.drones.constants.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "DRONE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drone extends Throwable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Length(max = 100)
    @NotBlank(message = "Serial Number is mandatory")
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private Model model;

    @Max(500)
    @Min(0)
    private double weightLimit;

    @Max(100)
    @Min(0)
    private int batteryCapacity;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "drone", fetch = FetchType.LAZY)
    private List<Medication> medications;

    public Drone(String serialNumber, Model model, double weightLimit, int batteryCapacity, State state) {

        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.serialNumber = serialNumber;
        this.model = model;
    }

}
