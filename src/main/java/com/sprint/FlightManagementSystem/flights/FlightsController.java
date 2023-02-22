package com.sprint.FlightManagementSystem.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flights> getAllFlights() {
        return (List<Flights>) flightRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flights> getFlightById(@PathVariable Long id) {
        Flights flights = flightRepository.findById(id).orElse(null);
        if (flights != null) {
            return new ResponseEntity<>(flights, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Flights> addFlight(@RequestBody Flights flights) {
        Flights newFlight = flightRepository.save(flights);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flights> updateFlight(@PathVariable Long id, @RequestBody Flights flights) {
        Flights existingFlight = flightRepository.findById(id).orElse(null);
        if (existingFlight != null) {
            existingFlight.setOrigin(flights.getOrigin());
            existingFlight.setDestination(flights.getDestination());
            existingFlight.setDepartureTime(flights.getDepartureTime());
            existingFlight.setArrivalTime(flights.getArrivalTime());
            existingFlight.setAircraft(flights.getAircraft());
            Flights updatedFlight = flightRepository.save(existingFlight);
            return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}