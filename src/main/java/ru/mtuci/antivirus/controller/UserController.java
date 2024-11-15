package ru.mtuci.antivirus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.antivirus.models.User;
import ru.mtuci.antivirus.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('read')")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/adduser")
    @PreAuthorize("hasAnyAuthority('modification')")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
