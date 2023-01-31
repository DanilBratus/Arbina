package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.request.DeviceRequest;
import org.example.model.response.DeviceResponse;
import org.example.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<DeviceResponse> allDevices() {
        return deviceService.allDevices();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public DeviceResponse createDevice(@RequestBody DeviceRequest request) {
        return deviceService.createDevice(request);
    }

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteDevice(@PathVariable Integer id) {
        deviceService.deleteDevice(id);
    }
}
