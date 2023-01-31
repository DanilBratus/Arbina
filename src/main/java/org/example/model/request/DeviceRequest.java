package org.example.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeviceRequest {
    private String nameDevice;
    private LocalDate releaseDate;
}
