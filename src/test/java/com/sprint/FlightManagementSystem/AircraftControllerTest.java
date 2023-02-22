package com.sprint.FlightManagementSystem;

import com.sprint.FlightManagementSystem.aircraft.AircraftRepository;
import com.sprint.FlightManagementSystem.airport.Airport;
import com.sprint.FlightManagementSystem.airport.AirportRepository;
import com.sprint.FlightManagementSystem.city.City;
import com.sprint.FlightManagementSystem.city.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AircraftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void testGetAllAircrafts() throws Exception {
        MvcResult result = mockMvc.perform(get("/aircrafts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<Airport> airportList = new ArrayList<>();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void testGetAircraftById() throws Exception {
        MvcResult result = mockMvc.perform(get("/aircrafts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<Airport> airportList = new ArrayList<>();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);

    }

}
