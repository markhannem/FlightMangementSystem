package com.sprint.FlightManagementSystem.passenger;

import com.sprint.FlightManagementSystem.aircraft.Aircraft;
import jakarta.persistence.*;
import com.sprint.FlightManagementSystem.city.City;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.text.CharacterIterator;


import java.util.List;

@Entity
public class Passenger {
    @Id

    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1)

    @GeneratedValue(generator = "passenger_sequence")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "aircraft_passenger",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id"))
    private List<Aircraft> aircraft;





    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircraft.add(aircraft);
    }

    public void removeAircraft(Aircraft aircraft) {
        this.aircraft.remove(aircraft);
    }


    public Passenger() {
    }



}




