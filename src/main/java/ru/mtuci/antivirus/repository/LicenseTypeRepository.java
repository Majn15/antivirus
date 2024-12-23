package ru.mtuci.antivirus.repository;

import ru.mtuci.antivirus.models.LicenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseTypeRepository extends JpaRepository<LicenseType, Long> {
}

