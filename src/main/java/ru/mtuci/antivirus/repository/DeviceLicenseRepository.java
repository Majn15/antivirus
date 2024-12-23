package ru.mtuci.antivirus.repository;

import ru.mtuci.antivirus.models.DeviceLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceLicenseRepository extends JpaRepository<DeviceLicense, Long> {
}
