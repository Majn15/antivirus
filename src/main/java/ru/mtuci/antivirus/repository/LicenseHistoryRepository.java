package ru.mtuci.antivirus.repository;

import ru.mtuci.antivirus.models.LicenseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseHistoryRepository extends JpaRepository<LicenseHistory, Long> {
    List<LicenseHistory> findByLicenseId(Long licenseId);
}

