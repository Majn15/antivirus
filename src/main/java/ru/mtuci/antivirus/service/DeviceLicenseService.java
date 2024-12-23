package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.DeviceLicense;
import ru.mtuci.antivirus.repository.DeviceLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceLicenseService {
    private final DeviceLicenseRepository deviceLicenseRepository;

    public List<DeviceLicense> findAll() {
        return deviceLicenseRepository.findAll();
    }

    public Optional<DeviceLicense> findById(Long id) {
        return deviceLicenseRepository.findById(id);
    }

    public DeviceLicense save(DeviceLicense deviceLicense) {
        return deviceLicenseRepository.save(deviceLicense);
    }

    public void deleteById(Long id) {
        deviceLicenseRepository.deleteById(id);
    }
}

