package com.sprint.FlightManagementSystem.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    // Get all aircraft
    @GetMapping("/aircrafts")
    public List<Aircraft> getAllAircraft() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }

    // Get aircraft by id
    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return aircraftRepository.findById(id).get();
    }

    // Create a new aircraft
    @PostMapping("/aircraft")
    public void createAircraft(@RequestBody Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    // Update an existing aircraft
    @PutMapping("/aircraft/{id}")
    public void updateAircraft(@PathVariable String id, @RequestBody Aircraft aircraft,
                               HttpServletResponse response) {
        Optional<Aircraft> returnValue = aircraftRepository.findById(Long.parseLong(id));
        Aircraft acToUpdate;


        if (returnValue.isPresent()) {
            acToUpdate = returnValue.get();

            acToUpdate.setType(aircraft.getType());
            acToUpdate.setAirlineName(aircraft.getAirlineName());
            acToUpdate.setNumberOfPassengers(aircraft.getNumberOfPassengers());


            aircraftRepository.save(acToUpdate);
        } else {
            try {
                response.sendError(404, "Aircraft with id: " + aircraft.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // Delete an existing aircraft
    @DeleteMapping("/aircraft/{id}")
    public void deleteAircraft (@PathVariable Long id){
        aircraftRepository.deleteById(id);
    }
}