package com.kawahedukasi.batch4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.model.User;
import com.kawahedukasi.batch4.repository.PesertaRepository;
import io.smallrye.common.annotation.Blocking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletionStage;

@Service
public class QuarkusService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    PesertaRepository pesertaRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public void sendToQuarkus(Peserta peserta) throws JsonProcessingException {
        kafkaTemplate.send("spring-peserta",objectMapper.writeValueAsString(peserta));
    }

    @KafkaListener(topics = "quarkus-peserta")
    @Blocking
    public void addPesertaFromQuarkus(String body) throws JsonProcessingException {
        Peserta peserta = objectMapper.readValue(body, Peserta.class);
        pesertaRepository.save(peserta);
    }
}
