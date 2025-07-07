package org.example.flightticketapp.user.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Date;


@Component
public class TokenGenerator {

    @Value("${jwt-key}")
    private String KEY;

    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;

    @Value("${jwt-variables.EXPIRES_ACCESS_TOKEN_MINUTE}")
    private Integer EXPIRES_ACCESS_TOKEN_MINUTES = 60;


    public String generateToken(Authentication authentication) {
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis()
                + EXPIRES_ACCESS_TOKEN_MINUTES * 60 * 1000))
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }

    public DecodedJWT verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            return verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid token: " + e.getMessage());
            //TODO : custom exception handling ile yapılacak
        }
    }


}
