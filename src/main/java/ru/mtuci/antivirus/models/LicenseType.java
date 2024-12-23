package ru.mtuci.antivirus.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "license_types")
public class LicenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer default_duration;

    private String description;

    @OneToMany(mappedBy = "licenseType")
    private Set<License> licenses;
}
