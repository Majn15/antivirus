package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.Device;
import ru.mtuci.antivirus.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public Optional<Device> findById(Long id) {
        return deviceRepository.findById(id);
    }

    public List<Device> findByUserId(Long userId) {
        return deviceRepository.findByUserId(userId);
    }

    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public void deleteById(Long id) {
        deviceRepository.deleteById(id);
    }
}

