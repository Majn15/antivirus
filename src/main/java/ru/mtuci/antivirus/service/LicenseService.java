package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.License;
import ru.mtuci.antivirus.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public List<License> findAll() {
        return licenseRepository.findAll();
    }

    public Optional<License> findById(Long id) {
        return licenseRepository.findById(id);
    }

    public List<License> findByUserId(Long userId) {
        return licenseRepository.findByUserId(userId);
    }

    public License save(License license) {
        return licenseRepository.save(license);
    }

    public void deleteById(Long id) {
        licenseRepository.deleteById(id);
    }
}

