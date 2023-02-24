package com.sprint.FlightManagementSystem.airport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sprint.FlightManagementSystem.city.City;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//@Entity
//@Table(name = "airport")
//public class Airport {
//    @Id
//    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
//    @GeneratedValue(generator = "airport_sequence")
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "code")
//    private String code;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "city_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private City city;
//    @Column(name = "city_id", insertable = false, updatable = false) private Long cityId;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "city_id", insertable = false, updatable = false)
    private Long cityId;
    public Airport() {
    }

    public Airport(City city) {
        this.city = city;
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

