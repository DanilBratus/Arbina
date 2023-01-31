package org.example.service;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.model.request.DeviceRequest;
import org.example.model.response.DeviceResponse;
import org.example.repositories.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository repository;

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<DeviceResponse> allDevices() {
        return repository.findAll()
                .stream()
                .map(this :: buildResponse)
                .collect(Collectors.toList());
    }

    private DeviceResponse buildResponse(Device device) {
        return new DeviceResponse()
                .setId(device.getId())
                .setUniqueIdentifier(device.getUniqueIdentifier())
                .setNameDevice(device.getNameDevice())
                .setReleaseDate(device.getReleaseDate());
    }

    @NotNull
    @Override
    @Transactional
    public DeviceResponse createDevice(@NotNull DeviceRequest request) {
        Device device = buildRequest(request);
        return buildResponse(repository.save(device));
    }

    private Device buildRequest(DeviceRequest request) {
        return new Device()
                .setReleaseDate(request.getReleaseDate())
                .setNameDevice(request.getNameDevice());
    }

    @Override
    @Transactional
    public void deleteDevice(@NotNull Integer id) {
        repository.deleteById(id);
    }
}
