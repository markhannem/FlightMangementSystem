package com.sprint.FlightManagementSystem.aircraft;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// save(), findOne(), findById(), findAll(), count(), delete(), deleteById(), etc...
public interface AircraftJpaRepository extends JpaRepository<Aircraft, Long> {
    List<Aircraft> findAircratByPassengerId(Long passenger_id);
}
