package com.kawahedukasi.batch4.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
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
    public ResponseEntity<Object> post(@RequestBody PesertaRequest request) throws JsonProcessingException {
        return pesertaService.post(request);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        return pesertaService.getById(id);
    }

    @GetMapping
    public ResponseEntity<Object> get(){
        return pesertaService.get();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable("email") String email){
        return pesertaService.getByEmail(email);
    }

    @GetMapping("/phoneNumberOrEmail")
    public ResponseEntity<Object> getByPhoneNumberOrEmail(@RequestParam("phoneNumber") String phoneNumber,@RequestParam("email") String email){
        return pesertaService.getByPhoneNumberOrEmail(phoneNumber, email);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable("id") Long id, @RequestBody PesertaRequest request){
        return pesertaService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        return pesertaService.delete(id);
    }
}
