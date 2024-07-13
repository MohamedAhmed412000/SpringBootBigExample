package com.project.users.services.impl;

import com.project.users.domain.enums.UserRoleCodeEnum;
import com.project.users.domain.enums.UserRoleEnum;
import com.project.users.domain.models.User;
import com.project.users.inbound.requests.AuthenticationRequest;
import com.project.users.inbound.requests.RegistrationRequest;
import com.project.users.inbound.responses.AuthenticationResponse;
import com.project.users.repositories.UserRepository;
import com.project.users.services.AuthenticationService;
import com.project.users.services.JwtUtilsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Getter
@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtUtilsService jwtUtilsService;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegistrationRequest request) {

        var user = User.builder()
            .firstName(request.getFirstname())
            .lastName(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .userType(new UserRoleEnum(UserRoleCodeEnum.USER.getValue()))
            .build();
        userRepository.save(user);
        String accessToken = jwtUtilsService.generateToken(user);
        return AuthenticationResponse.builder()
            .access_token(accessToken)
            .user(user)
            .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        var user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String accessToken = jwtUtilsService.generateToken(user);
        return AuthenticationResponse.builder()
            .access_token(accessToken)
            .user(user)
            .build();
    }

}
