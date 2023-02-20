package com.sprint.FlightManagementSystem.airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository
        extends CrudRepository<Airport, Long> {

    List<Airport> getAllAirports();

    Airport getAirportById(Long id);

    void createAirport(Airport airport);

    void updateAirport(Long id, Airport airport);

    void deleteAirport(Long id);
}