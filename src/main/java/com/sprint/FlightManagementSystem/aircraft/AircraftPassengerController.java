package com.sprint.FlightManagementSystem.aircraft;

import com.sprint.FlightManagementSystem.passenger.Passenger;
import com.sprint.FlightManagementSystem.passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("aircraft-passengers")
@RestController
@CrossOrigin
public class AircraftPassengerController {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    // Add a passenger to an aircraft
    @PostMapping("/{aircraftId}/passengers")
    public void addPassengerToAircraft(@PathVariable Long aircraftId, @RequestBody Passenger passenger,
                                       HttpServletResponse response) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);
        if (aircraft.isPresent()) {
            Aircraft acToUpdate = aircraft.get();
            List<Passenger> passengers = acToUpdate.getPassengers();
            passengers.add(passenger);
            acToUpdate.setPassengers(passengers);
            aircraftRepository.save(acToUpdate);
        } else {
            try {
                response.sendError(404, "Aircraft with id: " + aircraftId + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Remove a passenger from an aircraft
    @DeleteMapping("/{aircraftId}/passengers/{passengerId}")
    public void removePassengerFromAircraft(@PathVariable Long aircraftId, @PathVariable Long passengerId,
                                            HttpServletResponse response) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);
        if (aircraft.isPresent()) {
            Aircraft acToUpdate = aircraft.get();
            List<Passenger> passengers = acToUpdate.getPassengers();
            Optional<Passenger> passengerToRemove = passengers.stream().filter(p -> p.getId().equals(passengerId)).findFirst();
            if (passengerToRemove.isPresent()) {
                passengers.remove(passengerToRemove.get());
                acToUpdate.setPassengers(passengers);
                aircraftRepository.save(acToUpdate);
            } else {
                try {
                    response.sendError(404, "Passenger with id: " + passengerId + " not found on aircraft with id: " + aircraftId + ".");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            try {
                response.sendError(404, "Aircraft with id: " + aircraftId + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Get a list of all passengers on an aircraft
    @GetMapping("/{aircraftId}/passengers")
    public List<Passenger> getPassengersOnAircraft(@PathVariable Long aircraftId) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);
        if (aircraft.isPresent()) {
            return aircraft.get().getPassengers();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aircraft with id: " + aircraftId + " not found.");
        }
    }

}

