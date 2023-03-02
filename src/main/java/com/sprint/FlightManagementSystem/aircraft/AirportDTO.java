package com.sprint.FlightManagementSystem.aircraft;

public class AirportDTO {
    private String name;
    private String code;
    private Long city_id;

    public AirportDTO() {}

    public AirportDTO(String name, String code, Long city_id) {
        this.name = name;
        this.code = code;
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }
}

//The CreateAirportRequest class to handle the incoming JSON data for creating a new airport in the AirportController.
// The CreateAirportRequest class represents the incoming JSON object with its properties name, code, and cityId.
// When a client sends a POST request to create a new airport, the data in the request body is mapped to an instance of
// CreateAirportRequest, which is then used to create a new Airport entity with the necessary properties.
//
//By using a separate class for the request body, you can also validate the incoming data and add additional logic for
// creating the Airport entity. This separation of concerns makes the code easier to read, maintain, and test.