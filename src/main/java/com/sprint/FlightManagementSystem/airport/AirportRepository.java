package com.sprint.FlightManagementSystem.airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository
        extends CrudRepository<Airport, Long> {

}