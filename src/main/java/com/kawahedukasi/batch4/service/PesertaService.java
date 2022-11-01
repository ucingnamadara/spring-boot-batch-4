package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
import com.kawahedukasi.batch4.model.dto.IdPesertaResponse;
import com.kawahedukasi.batch4.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PesertaService {

    @Autowired
    PesertaRepository pesertaRepository;

    public ResponseEntity<Object> post(PesertaRequest request){
        Peserta peserta = new Peserta();
        peserta.name = request.name;
        peserta.address= request.address;
        peserta.email= request.email;
        peserta.phoneNumber= request.phoneNumber;
        peserta.role= request.role;
        peserta.className= request.className;
        peserta.batch= request.batch;

        peserta = pesertaRepository.save(peserta);

        IdPesertaResponse response = new IdPesertaResponse();
        response.id = peserta.id;
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Object> getById(Long id){
        Optional<Peserta> optionalPeserta = pesertaRepository.findById(id);
        if(optionalPeserta.isEmpty()){
            return new ResponseEntity<>("PESERTA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        Peserta peserta = optionalPeserta.get();
//        Map<String, Object> response = new HashMap<>();
//        response.put("name", peserta.name);
//        response.put("address", peserta.address);
//        response.put("email", peserta.email);
//        response.put("phoneNumber", peserta.phoneNumber);
//        response.put("role", peserta.role);
//        response.put("className", peserta.className);
//        response.put("batch", peserta.batch);
        return ResponseEntity.ok(peserta);
    }

    public ResponseEntity<Object> put(Long id, PesertaRequest request){
        Optional<Peserta> optionalPeserta = pesertaRepository.findById(id);
        if(optionalPeserta.isEmpty()){
            return new ResponseEntity<>("PESERTA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        Peserta peserta = optionalPeserta.get();

        peserta.name = request.name;
        peserta.address= request.address;
        peserta.email= request.email;
        peserta.phoneNumber= request.phoneNumber;
        peserta.role= request.role;
        peserta.className= request.className;
        peserta.batch= request.batch;

        peserta = pesertaRepository.save(peserta);

        IdPesertaResponse response = new IdPesertaResponse();
        response.id = peserta.id;
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Object> delete(Long id){
        pesertaRepository.deleteById(id);

        return ResponseEntity.ok(new HashMap<>());
    }

    public ResponseEntity<Object> get(){
        return ResponseEntity.ok(pesertaRepository.findAll());
    }

    public ResponseEntity<Object> getByEmail(String email){
        Optional<Peserta> optionalPeserta = pesertaRepository.findByEmail(email);
        if(optionalPeserta.isEmpty()){
            return new ResponseEntity<>("PESERTA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        Peserta peserta = optionalPeserta.get();
//        Map<String, Object> response = new HashMap<>();
//        response.put("name", peserta.name);
//        response.put("address", peserta.address);
//        response.put("email", peserta.email);
//        response.put("phoneNumber", peserta.phoneNumber);
//        response.put("role", peserta.role);
//        response.put("className", peserta.className);
//        response.put("batch", peserta.batch);
        return ResponseEntity.ok(peserta);
    }

    public ResponseEntity<Object> getByPhoneNumberOrEmail(String phoneNumber, String email){
        List<Peserta> listPeserta = pesertaRepository.findByPhoneNumberOrEmail(phoneNumber, email);

        return ResponseEntity.ok(listPeserta);
    }

}
