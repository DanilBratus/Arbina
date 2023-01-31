package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "electroDevice")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "uniqueIdentifier", nullable = false, unique = true)
    private String uniqueIdentifier = UUID.randomUUID().toString();

    @Column(name = "nameDevice", nullable = false)
    private String nameDevice;

    @Column(name = "releaseDate", nullable = false)
    private LocalDate releaseDate;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", uniqueIdentifier='" + uniqueIdentifier + '\'' +
                ", nameDevice='" + nameDevice + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
