package com.sprint.FlightManagementSystem.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerJpaRepository extends JpaRepository<Passenger, Long>{
    List<Passenger> findPassengersByAircraftId(Long aircraft_id);
}
