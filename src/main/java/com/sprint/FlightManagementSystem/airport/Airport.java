package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.aircraft.Aircraft;
import com.sprint.FlightManagementSystem.city.City;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_sequence")
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
    private Long id;
    private String name;
    private String code;
    private String maxAircraftSize;
    public Airport() {
    }

    @ManyToOne
    private City city;

    @OneToMany()
    private List<Aircraft> aircraftList;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    public void setMaxAircraftSize(String maxAircraftSize) {
        this.maxAircraftSize = maxAircraftSize;
    }
    public String getMaxAircraftSize() {
        return maxAircraftSize;
    }
    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }
    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
}
