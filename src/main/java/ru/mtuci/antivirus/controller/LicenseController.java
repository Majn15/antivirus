package ru.mtuci.antivirus.controller;

import ru.mtuci.antivirus.models.License;
import ru.mtuci.antivirus.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
@RequiredArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;

    @GetMapping
    public ResponseEntity<List<License>> getAllLicenses() {
        return ResponseEntity.ok(licenseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<License> getLicenseById(@PathVariable Long id) {
        return licenseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<License> createLicense(@RequestBody License license) {
        return ResponseEntity.ok(licenseService.save(license));
    }

    @PutMapping("/{id}")
    public ResponseEntity<License> updateLicense(@PathVariable Long id, @RequestBody License updatedLicense) {
        return licenseService.findById(id).map(license -> {
            license.setLicenseKey(updatedLicense.getLicenseKey());
            license.setFirst_activation_date(updatedLicense.getFirst_activation_date());
            license.setEnding_date(updatedLicense.getEnding_date());
            license.setBlocked(updatedLicense.isBlocked());
            return ResponseEntity.ok(licenseService.save(license));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicense(@PathVariable Long id) {
        if (licenseService.findById(id).isPresent()) {
            licenseService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

