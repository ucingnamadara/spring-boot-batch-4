package com.kawahedukasi.batch4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointNameController {

    @GetMapping("/info")
    public String info(){
        return "Kawahedukasi merupakan bootcamp java gratis";
    }

    @GetMapping("/address")
    public String address(){
        return "Bootcamp kawahedukasi dilakukan secara online";
    }

    @GetMapping("/mentor")
    public String mentor(){
        return "Kawahedukasi di mentori oleh ananda dan ridwan";
    }
}
