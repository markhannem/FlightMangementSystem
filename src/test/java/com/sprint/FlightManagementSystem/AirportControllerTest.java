package com.sprint.FlightManagementSystem;

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
public class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AirportRepository airportRepository;

    @MockBean
    private CityRepository cityRepository;

    @BeforeEach
    public void setup() {
//        City city = new City();
//        when(cityRepository.save(city)).thenReturn(city);

//        List<Airport> airportList = new ArrayList<>();

//        airportList.add(new Airport("Airport1", "AP1", city));
//        airportList.add(new Airport("Airport2", "AP2", city));
//        airportList.add(new Airport("Airport3", "AP3", city));

//        airportRepository.saveAll(airportList);
    }

    @Test
    public void testGetAllAirports() throws Exception {
        MvcResult result = mockMvc.perform(get("/airports")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<Airport> airportList = new ArrayList<>();

        String content = result.getResponse().getContentAsString();
//        assertThat(content).contains("Airport1");
//        assertThat(content).contains("Airport2");
//        assertThat(content).contains("Airport3");

        System.out.println(content);
    }

    @Test
    public void testGetAirportById() throws Exception {
        MvcResult result = mockMvc.perform(get("/airports/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(content).contains("");

        System.out.println(content);
    }

}