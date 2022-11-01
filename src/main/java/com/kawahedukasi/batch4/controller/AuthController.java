package com.kawahedukasi.batch4.controller;

import com.kawahedukasi.batch4.model.dto.Login;
import com.kawahedukasi.batch4.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Login request){
       return authService.login(request);
    }

//    @Path("/me")
//    @GET
//    public Response me(@Context SecurityContext securityContext){
//
//    }
}
