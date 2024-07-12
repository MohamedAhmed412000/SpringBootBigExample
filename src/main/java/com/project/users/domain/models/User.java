package com.project.users.domain.models;

import com.project.users.domain.enums.UserRoleEnum;
import com.project.users.domain.enums.converters.UserRoleEnumConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"USER\"")
public class User implements UserDetails {

    @Id
    @Column(name = "ID", columnDefinition = "uuid", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Convert(converter = UserRoleEnumConverter.class)
    @Column(name = "TYPE")
    private UserRoleEnum userType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserGroupRoleUser> userGroupRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userGroupRoles.stream()
                .map(UserGroupRoleUser::getUserGroupRole)
                .map(UserGroupRole::getRole)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Return true or implement your logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Return true or implement your logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Return true or implement your logic
    }

    @Override
    public boolean isEnabled() {
        return true; // Return true or implement your logic
    }

}
