package ru.mtuci.antivirus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date now_date;
    private Date activation_date;
    private Date ending_date;
    private Long expiration;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "device_id")
    private Long device_id;

    @Column(name = "is_blocked_licence")
    private boolean is_blocked_licence;

    private String digital_signature;
    private String description;
}
