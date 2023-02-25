package com.sprint.FlightManagementSystem.city;

import com.sprint.FlightManagementSystem.airport.Airport;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1)
    @GeneratedValue(generator = "city_sequence")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Airport> airports;

    @Column(name = "state")
    private String state;
    @Column(name = "population")
    private int population;

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

}
