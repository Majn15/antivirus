package ru.mtuci.antivirus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.antivirus.requests.RegistrationRequest;
import ru.mtuci.antivirus.models.User;
import ru.mtuci.antivirus.service.UserService;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody RegistrationRequest registrationRequest) {
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());

        if (!userService.saveUser(user, registrationRequest.getPassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Пользователь уже существует!");

        return ResponseEntity.ok("Регистрация прошла успешно!");
    }
}
