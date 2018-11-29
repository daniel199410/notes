package com.notes.core.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class JwtUtil {
    public static void addAuthentication(HttpServletResponse res, String username) {
        String token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, "P@tit0").compact();
        res.addHeader("Authorization", "Bearer " + token);
    }

    public static Authentication getAuthentication(HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader("Authorization");
        if(token != null) {
            String user = Jwts.parser().setSigningKey("P@tit0").parseClaimsJws(token.replace("Bearer", "")).getBody().getSubject();
            return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
        }
        return null;
    }
}
