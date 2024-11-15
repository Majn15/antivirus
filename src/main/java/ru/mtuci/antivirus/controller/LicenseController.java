package ru.mtuci.antivirus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.antivirus.models.License;
import ru.mtuci.antivirus.service.LicenseService;

import java.util.List;

@RestController
@RequestMapping("/license")
public class LicenseController {
    private final LicenseService licenseService;

    public  LicenseController(LicenseService licenseService){
        this.licenseService = licenseService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('read')")
    public List<License> findAll() { return licenseService.findAll(); }

    @PostMapping("/addlicense")
    @PreAuthorize("hasAnyAuthority('modification')")
    public void addLicense(@RequestBody License license) { licenseService.addLicense(license); }
}
