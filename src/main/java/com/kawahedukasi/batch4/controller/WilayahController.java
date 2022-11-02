package com.kawahedukasi.batch4.controller;

import com.kawahedukasi.batch4.service.WilayahService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/wilayah")
public class WilayahController {
    @Autowired
    WilayahService wilayahService;

    @GetMapping("/java-net/provinsi")
    public ResponseEntity<Object> provinsiListV1() throws IOException {
        return ResponseEntity.ok(wilayahService.provinsiListV1());
    }

    @GetMapping("/java-net/kota")
    public ResponseEntity<Object> kotaListV1() throws IOException {
        return ResponseEntity.ok(wilayahService.kotaListV1());
    }

    @GetMapping("/apache/provinsi")
    public ResponseEntity<Object> provinsiListV2() throws IOException {
        return ResponseEntity.ok(wilayahService.provinsiListV2());
    }

    @GetMapping("/apache/kota")
    public ResponseEntity<Object> kotaListV2() throws IOException {
        return ResponseEntity.ok(wilayahService.kotaListV2());
    }

    @GetMapping("/unirest/provinsi")
    public ResponseEntity<Object> provinsiListV3() throws IOException, UnirestException {
        return ResponseEntity.ok(wilayahService.provinsiListV3());
    }

    @GetMapping("/unirest/kota")
    public ResponseEntity<Object> kotaListV3() throws IOException, UnirestException {
        return ResponseEntity.ok(wilayahService.kotaListV3());
    }
}
