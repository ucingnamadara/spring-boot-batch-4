package com.kawahedukasi.batch4.util;

import com.kawahedukasi.batch4.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

public class TokenUtil {
    public static String generateToken(User user){
        return Jwts.builder().setSubject(user.username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 300000))
                .setClaims(Map.of(
                        "email", user.email ==null ? "" : user.email,
                        "phoneNumber", user.phoneNumber ==null ? "" : user.phoneNumber
                ))
                .signWith(SignatureAlgorithm.HS256, "kawahedukasi-issuer")
                .compact();
    }
}
