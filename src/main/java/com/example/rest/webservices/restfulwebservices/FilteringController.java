package com.example.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public People returnValues(){
        return new People("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<People> returnValuesList(){
        return Arrays.asList(new People("value1","value2","value3"),new People("value1","value2","value3"));
    }
}
