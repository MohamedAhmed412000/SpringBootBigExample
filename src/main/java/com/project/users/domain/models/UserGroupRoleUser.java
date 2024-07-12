package com.project.users.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_GROUP_USER")
public class UserGroupRoleUser {

    @EmbeddedId
    private UserGroupRoleUserId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("groupId")
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    private UserGroupRole group;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

}
