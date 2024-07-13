package com.project.users.repositories;

import com.project.users.domain.models.GroupRole;
import com.project.users.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface GroupRoleRepository extends JpaRepository<GroupRole, UUID> {

    @Query("SELECT DISTINCT gr.code FROM GroupRole gr")
    Set<String> findUserRolesFromDatabase();

}
