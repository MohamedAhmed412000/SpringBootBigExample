package com.project.users.inbound.controllers;

import com.project.users.inbound.requests.AuthenticationRequest;
import com.project.users.inbound.requests.RegistrationRequest;
import com.project.users.inbound.responses.AuthenticationResponse;
import com.project.users.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
        @RequestBody @Valid RegistrationRequest request
    ) {
        log.info("Register new User");
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
        @RequestBody @Valid AuthenticationRequest request
    ) {
        log.info("Authenticate User");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
