package ru.mtuci.antivirus.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "license")
public class License {
    @Id
    @GeneratedValue
    private int id;

    private String key, public_key, name;
}
