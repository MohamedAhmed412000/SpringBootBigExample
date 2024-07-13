package com.project.users.inbound.responses;

import com.project.users.domain.models.Role;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRolesResponse {

    private Set<Role> roles;

}
