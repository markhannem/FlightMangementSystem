package com.sprint.FlightManagementSystem.aircraft;

import com.sprint.FlightManagementSystem.flights.Flights;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_sequence")
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue=1)
    private Long id;
    private String type;
    private String airlineName;
    private int numberOfPassengers;
    private int maxRunwayLength;
    @OneToMany()
    private List<Flights> flights;

    @OneToMany()
    private List<Aircraft> aircraftList;
    public Aircraft() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    public String getAirlineName() {
        return airlineName;
    }
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setMaxRunwayLength(int maxRunwayLength) {
        this.maxRunwayLength = maxRunwayLength;
    }
    public int getMaxRunwayLength() {
        return maxRunwayLength;
    }
    public List<Flights> getFlights() {
        return flights;
    }
    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }
    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }


}
