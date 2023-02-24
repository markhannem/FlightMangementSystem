package com.sprint.FlightManagementSystem.airport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sprint.FlightManagementSystem.city.City;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airport_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

