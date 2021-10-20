package com.example.rest.webservices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PersonVersioningController {
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Anjana Ramankutty");
    }

    @GetMapping("/v2/person")
    public  PersonV2 personV2(){
        return new PersonV2(new Name("Vaiga"," Deepu"));
    }

    @GetMapping(value = "/v1/person/param",params = "version=1")
    public  PersonV1 paramV1(){
        return new PersonV1("Anjana Ramankutty");
    }

    @GetMapping(value = "/v1/person/param",params = "version=2")
    public  PersonV2 paramV2(){
        return new PersonV2(new Name("Vaiga"," Deepu"));
    }
}
