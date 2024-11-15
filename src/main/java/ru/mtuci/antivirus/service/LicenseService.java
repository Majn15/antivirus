package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.License;
import java.util.List;

public interface LicenseService {
    void addLicense(License license);
    List<License> findAll();
    License findById(long id);
}
