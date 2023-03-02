package com.sprint.FlightManagementSystem.passenger;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("passengers")
@RestController
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerRepository repo;

    @Autowired
    private PassengerRepository passengerRepository;
    @GetMapping
    public List<Passenger> getAllPassengers() {return (List<Passenger>) repo.findAll();}

    @PostMapping
    public  String createPassenger(@RequestBody Passenger passenger) {
        repo.save(passenger);
        return "Passenger Added";

    }

    @PutMapping(path = "{id}")
    public void updatePassenger(@PathVariable String id, @RequestBody Passenger passenger, HttpServletResponse response) {
        Optional<Passenger> returnValue = repo.findById(Long.parseLong(id));
        Passenger passengerToUpdate;

        if (returnValue.isPresent()) {
            passengerToUpdate = returnValue.get();

            passengerToUpdate.setFirstName(passenger.getFirstName());
            passengerToUpdate.setLastName(passenger.getLastName());
            passengerToUpdate.setPhoneNumber(passenger.getPhoneNumber());

            repo.save(passengerToUpdate);
        } else {
            try {
                response.sendError(404, "Passenger with id: " + passenger.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



    // DELETE REQUEST: Delete a Passenger
    @DeleteMapping(path = "{id}")
    public void deletePassenger(@PathVariable String id, HttpServletResponse response) {
        Optional<Passenger> returnValue = repo.findById(Long.parseLong(id));

        if (returnValue.isPresent()) {
            Passenger passengerToDelete = returnValue.get();
            repo.delete(passengerToDelete);
        } else {
            try {
                response.sendError(404, "Passenger with id: " + id + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}



