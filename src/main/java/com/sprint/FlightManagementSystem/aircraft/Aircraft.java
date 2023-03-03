package com.sprint.FlightManagementSystem.aircraft;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue= 1)
    @GeneratedValue(generator = "aircraft_sequence")
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name = "airlineName")
    private String airlineName;

    @Column(name = "numberOfPassengers")
    private int numberOfPassengers;

    @ElementCollection
    @CollectionTable(name = "aircraft_passenger_ids", joinColumns = @JoinColumn(name = "aircraft_id"))
    @Column(name = "passenger_id")
    private List<Long> passengerIds = new ArrayList<>();

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

    public List<Long> getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(List<Long> passengerIds) {
        this.passengerIds = passengerIds;
    }
}