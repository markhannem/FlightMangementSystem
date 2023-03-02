package com.sprint.FlightManagementSystem;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class FlightManagementSystemHttpClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String baseUrl = "http://localhost:8080";

        System.out.println("Flight Management System HTTP Client");
        System.out.println("------------------------------------");

        // What airports are in what cities?
        System.out.println("What airports are in what cities?");
        String cityUrl = baseUrl + "/cities";
        URL cityApiUrl = new URL(cityUrl);
        HttpURLConnection cityConnection = (HttpURLConnection) cityApiUrl.openConnection();
        cityConnection.setRequestMethod("GET");
        cityConnection.connect();
        int cityResponseCode = cityConnection.getResponseCode();
        if (cityResponseCode == 200) {
            String cityResponse = new Scanner(cityConnection.getInputStream()).useDelimiter("\\A").next();
            System.out.println(cityResponse);
        } else {
            System.out.println("Error: " + cityResponseCode + " " + cityConnection.getResponseMessage());
        }

        // List all aircraft passengers have travelled on?
        System.out.println("List all aircraft passengers have travelled on?");
        String aircraftUrl = baseUrl + "/aircrafts";
        URL aircraftApiUrl = new URL(aircraftUrl);
        HttpURLConnection aircraftConnection = (HttpURLConnection) aircraftApiUrl.openConnection();
        aircraftConnection.setRequestMethod("GET");
        aircraftConnection.connect();
        int aircraftResponseCode = aircraftConnection.getResponseCode();
        if (aircraftResponseCode == 200) {
            String aircraftResponse = new Scanner(aircraftConnection.getInputStream()).useDelimiter("\\A").next();
            System.out.println(aircraftResponse);
        } else {
            System.out.println("Error: " + aircraftResponseCode + " " + aircraftConnection.getResponseMessage());
        }

        // Which airports can aircraft take off from and land at?
        System.out.println("Which airports can aircraft take off from and land at?");
        String airportUrl = baseUrl + "/airports";
        URL airportApiUrl = new URL(airportUrl);
        HttpURLConnection airportConnection = (HttpURLConnection) airportApiUrl.openConnection();
        airportConnection.setRequestMethod("GET");
        airportConnection.connect();
        int airportResponseCode = airportConnection.getResponseCode();
        if (airportResponseCode == 200) {
            String airportResponse = new Scanner(airportConnection.getInputStream()).useDelimiter("\\A").next();
            System.out.println(airportResponse);
        } else {
            System.out.println("Error: " + airportResponseCode + " " + airportConnection.getResponseMessage());
        }

        // What airports have passengers used?
        System.out.println("What airports have passengers used?");
        String passengerUrl = baseUrl + "/passengers";
        URL passengerApiUrl = new URL(passengerUrl);
        HttpURLConnection passengerConnection = (HttpURLConnection) passengerApiUrl.openConnection();
        passengerConnection.setRequestMethod("GET");
        passengerConnection.connect();
        int passengerResponseCode = passengerConnection.getResponseCode();
        if (passengerResponseCode == 200) {
            String passengerResponse = new Scanner(passengerConnection.getInputStream()).useDelimiter("\\A").next();
            System.out.println(passengerResponse);
        } else {
            System.out.println("Error: " + passengerResponseCode + " " + passengerConnection.getResponseMessage());
        }

        scanner.close();
    }
}