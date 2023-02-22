package com.sprint.FlightManagementSystem.aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AircraftRepository
    extends CrudRepository<Aircraft, Long> {

}
