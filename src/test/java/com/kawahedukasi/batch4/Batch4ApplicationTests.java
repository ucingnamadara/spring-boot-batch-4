package com.kawahedukasi.batch4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawahedukasi.batch4.controller.PesertaController;
import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
import com.kawahedukasi.batch4.repository.PesertaRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Batch4ApplicationTests {

	@Autowired
	PesertaController pesertaController;

	@Mock
	PesertaRepository pesertaRepository;

	@Test
	@Order(1)
	public void post() throws JsonProcessingException {
		PesertaRequest request =  new PesertaRequest();
		request.name = "Test Dummy";
		request.email = "testdummy@email.com";
		request.phoneNumber = "089999999";
		request.address = "jl. dummy";
		request.className = "A";
		request.batch = 4;
		request.role = "BE";

		ResponseEntity<Object> response = pesertaController.post(request);
		Assertions.assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	@Order(2)
	public void getById(){
		ResponseEntity<Object> response = pesertaController.getById(1L);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}

}
