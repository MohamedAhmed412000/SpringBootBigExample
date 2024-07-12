package com.project.users.repositories;

import com.project.users.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query("SELECT DISTINCT r.code FROM User u JOIN UserGroupRoleUser ugru ON ugru.user = u.id " +
            "JOIN UserGroupRole ugr ON ugr.group = ugru.group " +
            "JOIN Role r ON ugr.role = r.id WHERE u.id = :userId")
    Set<String> findUserRolesByUserId(UUID userId);

}
