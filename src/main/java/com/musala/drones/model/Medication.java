package com.musala.drones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEDICATION")
@Data
@NoArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Pattern(regexp = "^[A-Za-z0-9_-]*$")
    private String name;

    private double weight;

    @Pattern(regexp = "^[A-Z0-9_]*$")
    private String code;

    private String image;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "drone_id", nullable = false)
    private Drone drone;

    public Medication(String name, double weight, String code, String image) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }

}
