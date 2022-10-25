package com.kawahedukasi.batch4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root/endpoint")
public class RootEndpointController {
    @GetMapping("/peserta")
    public String peserta(){
        return "Spring Boot : Peserta ada 50 orang";
    }

    @GetMapping("/materi")
    public String materi(){
        return "Spring Boot : Materi adalah spring boot & java";
    }

    @GetMapping("/jadwal")
    public String jadwal(){
        return "Spring Boot : Jadwal nya dalah senin - kamis";
    }
}
