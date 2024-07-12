package com.project.users.services;

import com.project.users.exceptions.UserNotFoundException;
import com.project.users.inbound.responses.UserDetailsResponse;

public interface UserInfoService extends org.springframework.security.core.userdetails.UserDetailsService {

    public UserDetailsResponse getUserDetails(String userId) throws UserNotFoundException;

}
