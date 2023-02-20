package com.sprint.FlightManagementSystem.aircraft;

import com.sprint.FlightManagementSystem.airport.Airport;
import com.sprint.FlightManagementSystem.airport.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    // Get all aircraft
    @GetMapping("/")
    public List<Aircraft> getAllAircraft() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }

    // Get aircraft by id
    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return aircraftRepository.findById(id).get();
    }

    // Create a new aircraft
    @PostMapping("/")
    public void createAircraft(@RequestBody Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    // Update an existing aircraft
    @PutMapping("/{id}")
    public void updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    // Delete an existing aircraft
    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftRepository.deleteById(id);
    }
}