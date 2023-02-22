package com.sprint.FlightManagementSystem.city;

import com.sprint.FlightManagementSystem.airport.Airport;
import com.sprint.FlightManagementSystem.passenger.Passenger;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "city_sequence")
    private Long id;
    private String name;

    private String state;
    private int population;

    @OneToMany()
    private List<Airport> airports;

    @OneToMany()
    private List<Passenger> passengers;

    public City() {
    }

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

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}