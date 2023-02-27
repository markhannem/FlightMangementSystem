package com.sprint.FlightManagementSystem.passenger;

import com.sprint.FlightManagementSystem.aircraft.Aircraft;
import jakarta.persistence.*;
import com.sprint.FlightManagementSystem.city.City;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.text.CharacterIterator;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "passenger_sequence")

    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private City city;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
                CascadeType.MERGE
        },
        mappedBy = "passenger")
    @JsonIgnore
    private Set<Aircraft> aircrafts = new HashSet<>();

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Aircraft> getAircrafts(){
        return aircrafts;
    }

    public void setAircrafts(Set<Aircraft> aircrafts){
        this.aircrafts = aircrafts;
    }

}




