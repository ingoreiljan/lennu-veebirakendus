package com.ingo.lennu_veebirakendus;


import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
    public List<Flight> getFilteredFlights(@RequestParam(value = "city", required = false) String city,
                                           @RequestParam(value = "startDate", required = false) String startDate,
                                           @RequestParam(value = "endDate", required = false) String endDate) {
        List<Flight> allFlights = fileReader.readFile();

        return allFlights.stream()
                .filter(flight -> (city == null || flight.getCity().equalsIgnoreCase(city)))
                .filter(flight -> isWithinDateRange(flight.getDate(), startDate, endDate))
                .collect(Collectors.toList());
    }

    private boolean isWithinDateRange(String flightDate, String startDate, String endDate) {
        if (startDate == null && endDate == null) return true;

        try {
            Date flight = new SimpleDateFormat("dd.MM.yyyy").parse(flightDate);
            if (startDate != null) {
                Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                if (flight.before(start)) return false;
            }
            if (endDate != null) {
                Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
                if (flight.after(end)) return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
