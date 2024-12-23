package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.configuration.SecurityConf;
import ru.mtuci.antivirus.models.Role;
import ru.mtuci.antivirus.models.User;
import ru.mtuci.antivirus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SecurityConf securityConf;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean saveUser(User user, String password) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB.isPresent()) return false;
        user.setRole(Role.USER);

        user.setPassword(securityConf.passwordEncoder().encode(password));
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());

        userRepository.save(user);
        return true;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

