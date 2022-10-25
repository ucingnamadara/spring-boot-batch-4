package com.kawahedukasi.batch4.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/http-verbs")
public class HttpVerbsController {

    @GetMapping
    public String get(){
        return "GET Spring Boot : Ini merupakan output GET HTTP VERBS";
    }

    @PostMapping
    public String post(){
        return "POST Spring Boot : Ini merupakan output POST HTTP VERBS";
    }

    @PutMapping
    public String put(){
        return "PUT Spring Boot : Ini merupakan output PUT HTTP VERBS";
    }

    @DeleteMapping
    public String delete(){
        return "DELETE Spring Boot : Ini merupakan output DELETE HTTP VERBS";
    }

}
