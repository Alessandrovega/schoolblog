package pe.edu.upc.schoolblog.security.middleware;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;




public class JwtHandler //para crear el token
{
    private static final Logger logger = LoggerFactory.getLogger(JwtHandler.class);
 @Value("${authorization.jwt.secret}")
    private String secret;

    @Value("${authorization.expiration.days}")
    private int expirationDays;


    public String generateToken(Authentication authentication) {
        String subject = ((UserDetailsImpl) authentication.getPrincipal()).getUsername();
        Date issuedAt = new Date();
       Date expiration = DateUtils.addDays(issuedAt, expirationDays);
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsernameFrom(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {

        return false;
    }
}
}
