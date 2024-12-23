package ru.mtuci.antivirus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.antivirus.models.License;

import java.util.List;

public interface LicenseRepository extends JpaRepository<License, Long> {
    List<License> findByUserId(Long userId);
    List<License> findByProductId(Long productId);
}
