package com.school.TutoringProgram.web;

import com.school.TutoringProgram.pojo.AccountCredentials;
import com.school.TutoringProgram.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<?> getToken (@RequestBody AccountCredentials credentials){
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        Authentication auth = authenticationManager.authenticate(creds);
        String jwts = jwtService.getToken(auth.getName());
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "AUTHORIZATION")
                .build();
    }
}
