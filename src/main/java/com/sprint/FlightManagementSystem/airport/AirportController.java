package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    // GET REQUEST: All Airports
    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    @GetMapping("/airport/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportRepository.findById(id).get();
    }

    // POST REQUEST: Create an Airport
    @PostMapping("/airport")
    public void createAirport(@RequestBody Airport airport) {
        airportRepository.save(airport);
    }

    // PUT REQUEST: Update an Airport
    @PutMapping("/airport/{id}")
    public void updateAirport(@PathVariable String id, @RequestBody Airport airport,
                               HttpServletResponse response) {
        Optional<Airport> returnValue = airportRepository.findById(Long.parseLong(id));
        Airport apToUpdate;


        if (returnValue.isPresent()) {
            apToUpdate = returnValue.get();

            apToUpdate.setName(airport.getName());
            apToUpdate.setCode(airport.getCode());


            airportRepository.save(airport);
        } else {
            try {
                response.sendError(404, "Airport with id: " + airport.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // DELETE REQUEST: Delete an Airport
    @DeleteMapping("/airport/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportRepository.deleteById(id);
    }

}