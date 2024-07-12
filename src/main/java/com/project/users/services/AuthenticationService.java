package com.project.users.services;

import com.project.users.inbound.requests.AuthenticationRequest;
import com.project.users.inbound.requests.RegistrationRequest;
import com.project.users.inbound.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegistrationRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
