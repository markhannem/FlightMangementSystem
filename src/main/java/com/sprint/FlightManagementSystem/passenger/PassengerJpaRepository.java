package com.sprint.FlightManagementSystem.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerJpaRepository extends JpaRepository<Passenger, Long>{
    List<Passenger> findPassengersByAircraftId(Long aircraft_id);
}
