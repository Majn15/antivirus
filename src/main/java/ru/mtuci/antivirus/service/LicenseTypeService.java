package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.LicenseType;
import ru.mtuci.antivirus.repository.LicenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LicenseTypeService {
    private final LicenseTypeRepository licenseTypeRepository;

    public List<LicenseType> findAll() {
        return licenseTypeRepository.findAll();
    }

    public Optional<LicenseType> findById(Long id) {
        return licenseTypeRepository.findById(id);
    }

    public LicenseType save(LicenseType licenseType) {
        return licenseTypeRepository.save(licenseType);
    }

    public void deleteById(Long id) {
        licenseTypeRepository.deleteById(id);
    }
}
