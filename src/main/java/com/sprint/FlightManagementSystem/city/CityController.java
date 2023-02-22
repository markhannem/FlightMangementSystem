package com.sprint.FlightManagementSystem.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityRepository repo;

    // GET REQUEST: All Cities
    @GetMapping("/cities")
    public List<City> getAllCities() {
        return (List<City>) repo.findAll();
    }

    // POST REQUEST: Create a City
    @PostMapping("/city")
    public void createCity(@RequestBody City city) {
        repo.save(city);
    }

    // PUT REQUEST: Update a City
    @PutMapping("/city/{id}")
    public void updateCity(@PathVariable String id, @RequestBody City city,
                           HttpServletResponse response)
    {
        Optional<City> returnValue = repo.findById(Long.parseLong(id));
        City cityToUpdate;


        if (returnValue.isPresent()) {
            cityToUpdate = returnValue.get();

            cityToUpdate.setName(city.getName());
            cityToUpdate.setPopulation(city.getPopulation());
            cityToUpdate.setState(city.getState());

            repo.save(cityToUpdate);
        } else {
            try {
                response.sendError(404, "City with id: " + city.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
