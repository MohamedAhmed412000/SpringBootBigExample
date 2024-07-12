package com.project.users.repositories;

import com.project.users.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query("SELECT DISTINCT r.code FROM User u " +
            "JOIN UserGroupRoleUser ugru ON ugru.user.id = u.id " +
            "JOIN UserGroupRole ugr ON ugr.groupRole.id = ugru.userGroupRole.id " +
            "JOIN Role r ON ugr.role.id = r.id " +
            "WHERE u.id = :userId")
    Set<String> findUserRolesByUserId(UUID userId);

}
