package com.kawahedukasi.batch4.service;


import com.kawahedukasi.batch4.model.User;
import com.kawahedukasi.batch4.model.dto.Login;
import com.kawahedukasi.batch4.repository.UserRepository;
import com.kawahedukasi.batch4.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> login(Login request){
        System.out.println(request.username);
        Optional<User> optionalUser = userRepository.findByUsername(request.username);
        if(optionalUser.isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("message", "USER_NOT_FOUND"));
        }

        User user = optionalUser.get();
        String password = Base64.getEncoder().encodeToString(request.password.getBytes(StandardCharsets.UTF_8));;


        if(!password.equals(user.password)){
            return ResponseEntity.badRequest().body(Map.of("message", "WRONG_PASSWORD"));
        }


        return ResponseEntity.ok(Map.of("token", TokenUtil.generateToken(user)));

    }
}
