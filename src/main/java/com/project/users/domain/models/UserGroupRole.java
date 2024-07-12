package com.project.users.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "USER_GROUP")
public class UserGroupRole {

    @Id
    @Column(name = "ID", columnDefinition = "uuid", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("groupId")
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    private GroupRole group;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false)
    private Role role;

}
