package com.project.users.services.impl;

import com.project.users.exceptions.UserNotFoundException;
import com.project.users.inbound.responses.UserDetailsResponse;
import com.project.users.services.UserInfoService;
import com.project.users.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Couldn't find user by email = " + email));
    }

    @Override
    public UserDetailsResponse getUserDetails(String userId) throws UserNotFoundException {
        var user = userRepository.findById(UUID.fromString(userId))
            .orElseThrow(() -> new UsernameNotFoundException("Couldn't find user by id = " + userId));
        return UserDetailsResponse.builder()
            .user(user)
            .build();
    }

}
