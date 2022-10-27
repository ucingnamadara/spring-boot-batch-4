package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PesertaService {

    @Autowired
    PesertaRepository pesertaRepository;

    public ResponseEntity<String> post(String name, String address, String email,
                                       String phoneNumber, String role, String className, Integer batch){
        Peserta peserta = new Peserta();
        peserta.name =name;
        peserta.address=address;
        peserta.email=email;
        peserta.phoneNumber=phoneNumber;
        peserta.role=role;
        peserta.className=className;
        peserta.batch=batch;

        peserta = pesertaRepository.save(peserta);

        return ResponseEntity.ok("id : " + peserta.id);
    }

    public ResponseEntity<String> getById(Long id){
        Optional<Peserta> optionalPeserta = pesertaRepository.findById(id);
        if(optionalPeserta.isEmpty()){
            return new ResponseEntity<>("PESERTA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        Peserta peserta = optionalPeserta.get();
        return ResponseEntity.ok(peserta.toString());
    }
}
