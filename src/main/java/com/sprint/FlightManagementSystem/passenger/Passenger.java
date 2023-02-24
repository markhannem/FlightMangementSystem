package com.sprint.FlightManagementSystem.passenger;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "passenger_sequence")

    private Long id;

    @Column(name = "firstName" )
    private String firstName;

    @Column(name ="lastName")
    private String lastName;

    @Column(name="phoneNumber")
    private String phoneNumber;

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



