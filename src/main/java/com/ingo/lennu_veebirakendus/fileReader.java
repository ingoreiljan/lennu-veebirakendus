package com.ingo.lennu_veebirakendus;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class fileReader {

    private static final String FILE_PATH = "src/main/resources/static/lennud.txt";  // File path to read

    // Method to read file content
    public static List<String> readFile() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
