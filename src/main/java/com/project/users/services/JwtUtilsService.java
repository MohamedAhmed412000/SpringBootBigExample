package com.project.users.services;

import com.project.users.domain.models.User;

public interface JwtUtilsService {

    public String extractUsername(String token);
    public String generateToken(User user);
    public boolean validateToken(String token, User user);

}
