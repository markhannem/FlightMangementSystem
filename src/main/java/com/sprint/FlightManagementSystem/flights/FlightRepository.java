package com.sprint.FlightManagementSystem.flights;
import com.sprint.FlightManagementSystem.flights.FlightRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flights, Long> {
}