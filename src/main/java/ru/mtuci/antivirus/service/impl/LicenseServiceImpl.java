package ru.mtuci.antivirus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.antivirus.models.License;
import ru.mtuci.antivirus.repository.LicenseRepository;
import ru.mtuci.antivirus.service.LicenseService;

import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService {
    LicenseRepository licenseRepository;

    @Autowired
    public LicenseServiceImpl(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
    }

    @Override
    public void addLicense(License license) {
        licenseRepository.save(license);
    }

    @Override
    public List<License> findAll() {
        List<License> licenseList = licenseRepository.findAll();
        return licenseList;
    }

    @Override
    public License findById(long id) {
        return licenseRepository.getOne(id);
    }
}
