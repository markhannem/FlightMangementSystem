package com.sprint.FlightManagementSystem.aircraft;

import jakarta.persistence.*;

@Entity
public class Aircraft {
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "aircraft_sequence")
    private Long id;
    private String type;
    private String airlineName;
    private int numberOfPassengers;

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

}
