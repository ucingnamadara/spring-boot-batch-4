package com.kawahedukasi.batch4.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BangunDatarService {
    public ResponseEntity<String> luasPersegi(Integer sisi){
        if(sisi < 1){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        Integer result = (sisi*sisi);
        //return ResponseEntity.ok("Luas Persegi : " + result);
        return new ResponseEntity<String>("Luas Persegi : " + result, HttpStatus.OK);
    }

    public ResponseEntity<String> kelilingPersegi(Integer sisi){
        if(sisi < 1){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        Integer result = (sisi*4);
        return ResponseEntity.ok("Keliling Persegi : " + result);
    }
}
