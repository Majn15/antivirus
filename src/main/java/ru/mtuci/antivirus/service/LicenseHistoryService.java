package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.LicenseHistory;
import ru.mtuci.antivirus.repository.LicenseHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LicenseHistoryService {
    private final LicenseHistoryRepository licenseHistoryRepository;

    public List<LicenseHistory> findAll() {
        return licenseHistoryRepository.findAll();
    }

    public Optional<LicenseHistory> findById(Long id) {
        return licenseHistoryRepository.findById(id);
    }

    public List<LicenseHistory> findByLicenseId(Long licenseId) {
        return licenseHistoryRepository.findByLicenseId(licenseId);
    }

    public LicenseHistory save(LicenseHistory licenseHistory) {
        return licenseHistoryRepository.save(licenseHistory);
    }

    public void deleteById(Long id) {
        licenseHistoryRepository.deleteById(id);
    }
}
