package org.example.service;

import com.sun.istack.NotNull;
import org.example.model.request.DeviceRequest;
import org.example.model.response.DeviceResponse;

import java.util.List;

public interface DeviceService {

    @NotNull
    List<DeviceResponse> allDevices();

    @NotNull
    DeviceResponse createDevice(@NotNull DeviceRequest request);

    void deleteDevice(@NotNull Integer id);
}
