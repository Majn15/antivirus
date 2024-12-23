package ru.mtuci.antivirus.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Device> devices;

    @OneToMany(mappedBy = "user")
    private Set<License> licenses;

    @OneToMany(mappedBy = "user")
    private Set<LicenseHistory> licenseHistories;

    @Column(nullable = false)
    private Role role;
}
