package com.pfpl.apigateway.util;


import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	
	  @Value("${secret}") 
	  public static String secret;
	 

	/*
	 * @Value("${expiration-time}") private long jwtExpiration;
	 */
    public static final String SECRET = "be6906729823cb7d20d5b4fdb04edde948d424ff2dbb4a1d5498f5a0c14b3a25";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }



    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
