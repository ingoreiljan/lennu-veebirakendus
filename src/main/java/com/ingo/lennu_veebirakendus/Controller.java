package com.ingo.lennu_veebirakendus;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class Controller {

    // New /lennud route
    @GetMapping("/lennud")
    public List<Flight> getLennud() {
        // Use fileReader to read the content of the file
        return fileReader.readFile();  // Returns the list of lines from the file
    }

    @GetMapping("/filter")
    public List<Flight> getFilteredFlights(@RequestParam("city") String city) {
        List<Flight> allFlights = fileReader.readFile();
        return allFlights.stream()
                .filter(flight -> flight.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @GetMapping("/cities")
    public List<String> getCities() {
        List<Flight> allFlights = fileReader.readFile();
        return allFlights.stream()
                .map(Flight::getCity)
                .distinct()
                .collect(Collectors.toList());  // Return unique cities
    }

    @GetMapping("/seatingdata")
    public Flight getSeatingDetails(@RequestParam String city, @RequestParam String date, @RequestParam String time) {
        List<Flight> allFlights = fileReader.readFile();
        return allFlights.stream()
                .filter(flight -> flight.getCity().equalsIgnoreCase(city)
                        && flight.getDate().equals(date)
                        && flight.getTime().equals(time))
                .findFirst()
                .orElse(null);  // Return null if no matching flight is found
    }

    private Set<Integer> occupiedSeats = null;

    @GetMapping("/seats")
    public Map<String, Object> getSeatData(@RequestParam(required = false) Boolean windowPref, @RequestParam(required = false) Boolean legroomPref) {
        if (occupiedSeats == null) {
            occupiedSeats = new Seats(false, false, null).getOccupiedSeats(); // Generate only once
        }
        Seats seats = new Seats(windowPref, legroomPref, occupiedSeats);
        return seats.getSeatData();
    }


}
