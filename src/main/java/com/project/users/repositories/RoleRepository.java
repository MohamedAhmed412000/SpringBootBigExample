package com.project.users.repositories;

import com.project.users.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query("SELECT DISTINCT r FROM User u " +
            "JOIN GroupRole gr ON gr.code = u.userType " +
            "JOIN UserGroupRole ugr ON ugr.groupRole.id = gr.id " +
            "JOIN Role r ON ugr.role.id = r.id " +
            "WHERE u.id = :userId")
    Set<Role> findUserRolesByUserId(UUID userId);

    @Query("SELECT DISTINCT r.code FROM Role r " +
            "JOIN UserGroupRole ugr ON ugr.role.id = r.id " +
            "JOIN GroupRole gr ON gr.id = ugr.groupRole.id " +
            "WHERE gr.code = :code")
    Set<String> findUserPermissionsByRoleFromDatabase(String code);

}
