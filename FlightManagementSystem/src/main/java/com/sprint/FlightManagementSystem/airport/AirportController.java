package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import com.sprint.FlightManagementSystem.airport.AirportRepository;

import java.util.List;
//import javax.validation.Valid;


@RestController
@CrossOrigin
public class AirportController {
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    // Get all airports
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.getAllAirports();
    }

    // Get airport by id
    @GetMapping
    public Airport getAirportById(@PathVariable Long id) {
        return airportRepository.getAirportById(id);
    }

    // Create a new Airport
    @PostMapping
    public void createAirport(@RequestBody Airport airport) {
        airportRepository.createAirport(airport);
    }

    // Update an Existing Airport
    @PutMapping
    public void updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        airportRepository.updateAirport(id, airport);
    }

    // Delete an Existing Airport
    @DeleteMapping
    public void deleteAirport(@PathVariable Long id) {
        airportRepository.deleteAirport(id);
    }



}
