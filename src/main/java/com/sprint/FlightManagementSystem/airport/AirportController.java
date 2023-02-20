package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import com.sprint.FlightManagementSystem.airport.AirportRepository;

import java.util.List;
//import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportRepository.findById(id).get();
    }

    @PostMapping
    public void createAirport(@RequestBody Airport airport) {
        airportRepository.save(airport);
    }

    @PutMapping("/{id}")
    public void updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        airportRepository.save(airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportRepository.deleteById(id);
    }

}