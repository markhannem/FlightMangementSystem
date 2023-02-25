package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.CreateAirportRequest;
import com.sprint.FlightManagementSystem.city.City;
import com.sprint.FlightManagementSystem.city.CityRepository;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;

@RequestMapping("airports")
@RestController
@CrossOrigin
public class AirportController {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    // GET REQUEST: All Airports
    @GetMapping
    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportRepository.findById(id).get();
    }

    // POST REQUEST: Create an Airport

    @Transactional
    @PostMapping
    public Airport createAirport(@RequestBody CreateAirportRequest request) {
        Airport airport = new Airport();
        airport.setName(request.getName());
        airport.setCode(request.getCode());

        Long cityId = request.getCity_id();
        if (cityId != null) {
            City city = entityManager.find(City.class, cityId);
            airport.setCity(city);
        }

        entityManager.persist(airport);
        return airport;
    }
    // PUT REQUEST: Update an Airport
    @PutMapping(path = "{id}")
    public void updateAirport(@PathVariable String id, @RequestBody Airport airport,
                               HttpServletResponse response) {
        Optional<Airport> returnValue = airportRepository.findById(Long.parseLong(id));
        Airport apToUpdate;
        if (returnValue.isPresent()) {
            apToUpdate = returnValue.get();
            apToUpdate.setName(airport.getName());
            apToUpdate.setCode(airport.getCode());
            airportRepository.save(apToUpdate);
        } else {
            try {
                response.sendError(404, "Airport with id: " + airport.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // DELETE REQUEST: Delete an Airport
    @DeleteMapping(path = "{id}")
    public void deleteAirport(@PathVariable Long id, HttpServletResponse response) {
        Optional<Airport> returnValue = airportRepository.findById(id);

        if (returnValue.isPresent()) {
            airportRepository.deleteById(id);
        } else {
            try {
                response.sendError(404, "Airport with id: " + id + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}