package com.project.users.domain.enums.config;

import com.project.users.domain.enums.UserRoleEnum;
import com.project.users.repositories.GroupRoleRepository;
import com.project.users.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

@Data
@RequiredArgsConstructor
@Configuration
public class UserPermissionEnumConfig {

    private final GroupRoleRepository groupRoleRepository;
    private final RoleRepository roleRepository;

    public static Map<String, Set<String>> permissions = new HashMap<>();
    public static Set<String> permissionsSet = new HashSet<>();

    @PostConstruct
    public void init() {
        generatePermissionRoles();
    }

    private void generatePermissionRoles() {
        for (String role : groupRoleRepository.findUserRolesFromDatabase()) {
            Set<String> rolePermissions = roleRepository.findUserPermissionsByRoleFromDatabase(role);
            permissions.put(role, rolePermissions);
            permissionsSet.addAll(rolePermissions);
        }
    }

    public static List<SimpleGrantedAuthority> getUserPermissions(UserRoleEnum userRoleEnum) {
        return permissions.getOrDefault(userRoleEnum.value(), Collections.emptySet())
               .stream()
               .map(SimpleGrantedAuthority::new)
               .toList();
    }

}
