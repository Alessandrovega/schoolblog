package pe.edu.upc.schoolblog.security.middleware;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Key;
import java.util.*;

public class JwtHandler2 {

    private final static  String ACCESS_TOKEN_SECRET= "qhq8LrEBfYcaRHxhdb9zURb";
    private final static Long ACCESS_TOKEN_SECONDS= 2_592_000L;

    public static String createToken(String nombre,String email){
        long expirationTime = ACCESS_TOKEN_SECONDS * 1_000;
        Date expirationDate= new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username",nombre);

        return Jwts.builder().setSubject(email).setExpiration(expirationDate).addClaims(extra).signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).build().parseClaimsJws(token).getBody();
            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, Collections.emptyList());

        } catch (JwtException e) {

            return null;
        }

    }

}
