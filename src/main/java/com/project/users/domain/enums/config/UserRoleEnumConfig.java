package com.project.users.domain.enums.config;

import com.project.users.repositories.GroupRoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Configuration
public class UserRoleEnumConfig {

    private final GroupRoleRepository groupRoleRepository;

    public static Set<String> roles = new HashSet<>();

    @PostConstruct
    public void init() {
        generateUserRoles();
    }

    public void generateUserRoles() {
        roles = groupRoleRepository.findUserRolesFromDatabase();
    }

}
