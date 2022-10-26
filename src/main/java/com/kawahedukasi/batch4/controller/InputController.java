package com.kawahedukasi.batch4.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class InputController {

    @GetMapping
    public String queryParam(@RequestParam("input") String input){
        return "SPRING BOOT : " + input.toUpperCase();
    }

    @GetMapping("/{input}")
    public String pathParam(@PathVariable("input") String input){
        return "Spring Boot, congrats you create a input path param : " + input;
    }

    @GetMapping("/header")
    public String header(
            @RequestHeader("name") String name,
            @RequestHeader("address") String address,
            @RequestHeader("age") Integer age
    ){
        return "Spring Boot, Nama : " + name.toUpperCase()
                + " address : " + address.toUpperCase()
                + " age : " + age;
    }

    @PostMapping("/body")
    public String body(@RequestBody String input){
        return "Spring Boot : " + input;
    }
}
