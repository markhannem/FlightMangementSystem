package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.city.City;
import jakarta.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1)
    @GeneratedValue(generator = "airport_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

//    @Column (name = "runway_length")
//    private int runway_length;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Airport() {
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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
//
//    public void setRunway_length(int runway_length) {
//        this.runway_length = runway_length;
//    }
//
//    public int getRunway_length() {
//        return runway_length;
//    }

}