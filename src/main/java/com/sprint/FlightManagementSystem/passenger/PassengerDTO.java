package com.sprint.FlightManagementSystem.passenger;

import java.util.Set;

public class PassengerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Long cityId;
    private Set<Long> aircraftIds;

    public PassengerDTO() {
    }

    public PassengerDTO(Long id, String firstName, String lastName, String phoneNumber, Long cityId, Set<Long> aircraftIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.cityId = cityId;
        this.aircraftIds = aircraftIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Set<Long> getAircraftIds() {
        return aircraftIds;
    }

    public void setAircraftIds(Set<Long> aircraftIds) {
        this.aircraftIds = aircraftIds;
    }
}