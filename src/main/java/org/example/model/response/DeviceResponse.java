package org.example.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class DeviceResponse {
    private Integer id;
    private String uniqueIdentifier;
    private String nameDevice;
    private LocalDate releaseDate;
}
