package com.kawahedukasi.batch4.controller;

import com.kawahedukasi.batch4.service.BangunDatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bangun-datar")
public class BangunDatarController {

    @Autowired
    BangunDatarService bangunDatarService;

    @GetMapping("/luasPersegi")
    public ResponseEntity<String> luasPersegi(@RequestParam("sisi") Integer sisi){
        return bangunDatarService.luasPersegi(sisi);
    }

    @GetMapping("/kelilingPersegi")
    public ResponseEntity<String> kelilingPersegi(@RequestParam("sisi") Integer sisi){
        return bangunDatarService.kelilingPersegi(sisi);
    }
}
