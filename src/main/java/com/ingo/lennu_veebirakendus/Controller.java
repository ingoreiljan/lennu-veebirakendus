package com.ingo.lennu_veebirakendus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

}
