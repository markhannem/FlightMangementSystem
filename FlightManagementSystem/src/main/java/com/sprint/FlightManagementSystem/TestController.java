package com.sprint.FlightManagementSystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
        @GetMapping(value = "/")
        public String getPage() {
            return "TEST";
        }
}
