package com.ingo.lennu_veebirakendus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {




    // New /lennud route
    @GetMapping("/lennud")
    public List<String> getLennud() {
        // Use fileReader to read the content of the file
        return fileReader.readFile();  // Returns the list of lines from the file
    }
}
