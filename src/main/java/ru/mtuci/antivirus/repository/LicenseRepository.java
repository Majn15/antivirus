package ru.mtuci.antivirus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtuci.antivirus.models.License;
import java.util.Optional;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
    Optional<License> findByID(int id);
}
