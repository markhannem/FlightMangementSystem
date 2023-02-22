package com.sprint.FlightManagementSystem.passenger;

import com.sprint.FlightManagementSystem.aircraft.Aircraft;
import jakarta.persistence.*;
import org.hibernate.mapping.List;

@Entity
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "passenger_sequence")
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "aircraft_passenger",
            joinColumns = @JoinColumn(name = "aircraft_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )



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

}



