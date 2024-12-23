package ru.mtuci.antivirus.requests;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username, email, password;
}
