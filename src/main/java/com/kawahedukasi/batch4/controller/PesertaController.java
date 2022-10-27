package com.kawahedukasi.batch4.controller;

import com.kawahedukasi.batch4.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peserta")
public class PesertaController {

    @Autowired
    PesertaService pesertaService;

    @PostMapping
    public ResponseEntity<String> post(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("role") String role,
            @RequestParam("className") String className,
            @RequestParam("batch") Integer batch
    ){
        return pesertaService.post(name, address, email, phoneNumber, role, className, batch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") Long id){
        return pesertaService.getById(id);
    }
}
