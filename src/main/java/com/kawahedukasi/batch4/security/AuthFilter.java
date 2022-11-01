package com.kawahedukasi.batch4.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        try{

            String authorization = httpRequest.getHeader("Authorization");
            String[] tokenOptional = authorization.split("(?:B|b)earer ");
            if(tokenOptional.length > 0){
                String token = tokenOptional[1];
                Claims claims = Jwts.parser().setSigningKey("kawahedukasi-issuer").parseClaimsJws(token).getBody();

                String username = claims.getSubject();
                httpRequest.setAttribute("username", username);
            }
            else {
                httpResponse.sendError(400, "UNAUTHORIZED");
            }
        }
        catch (Exception e){
            httpResponse.sendError(400, "UNAUTHORIZED");
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
