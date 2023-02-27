package com.sprint.FlightManagementSystem.aircraft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// save(), findOne(), findById(), findAll(), count(), delete(), deleteById(), etc...
public interface AircraftJpaRepository extends JpaRepository<Aircraft, Long> {
    List<Aircraft> findAircratByPassengerId(Long passenger_id);
}
