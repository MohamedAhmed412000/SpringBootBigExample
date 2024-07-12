package com.project.users.domain.models;

import com.project.users.domain.enums.UserRoleEnum;
import com.project.users.domain.enums.converters.UserRoleEnumConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "\"ROLE\"")
public class Role {

    @Id
    @Column(name = "ID", columnDefinition = "uuid", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ROLE_CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "ROLE_EN_NAME")
    private String nameEn;

    @Column(name = "ROLE_AR_NAME")
    private String nameAr;

}
