package org.example.flightticketapp.user.service;

import org.example.flightticketapp.user.dto.TokenResponseDto;
import org.example.flightticketapp.user.request.LoginRequest;
import org.example.flightticketapp.user.util.TokenGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthorizationService(UserService userService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponseDto login(LoginRequest loginRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            ));

            return TokenResponseDto.builder()
                    .accessToken(tokenGenerator.generateToken(authentication))
                    //.userDto(userService.getUser(loginRequest.getUsername())) TODO
                    .build();
        }catch (Exception e){
            throw new RuntimeException("User not found", e);
        }
    }
}
