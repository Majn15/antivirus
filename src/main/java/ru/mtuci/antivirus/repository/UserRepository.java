package ru.mtuci.antivirus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.antivirus.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
