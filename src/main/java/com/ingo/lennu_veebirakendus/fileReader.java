package com.ingo.lennu_veebirakendus;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class fileReader {

    private static final String FILE_PATH = "src/main/resources/static/lennud.txt";  // File path to read

    // Method to read and parse the file content into a list of Flight objects
    public static List<Flight> readFile() {
        List<Flight> flights = new ArrayList<>();
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

            // Parse each line and create a Flight object
            for (String line : lines) {
                String[] parts = line.split(","); // Split by comma
                if (parts.length == 3) {
                    String city = parts[0].trim();   // City
                    String date = parts[1].trim();   // Date
                    String time = parts[2].trim();   // Time
                    flights.add(new Flight(city, date, time)); // Add to the list
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }

    // Main method to test reading the file and displaying its content
    public static void main(String[] args) {
        List<Flight> flights = readFile();

        // Output the content of the file
        if (flights.isEmpty()) {
            System.out.println("File is empty or not found.");
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);  // Using the toString method of Flight
            }
        }
    }
}
