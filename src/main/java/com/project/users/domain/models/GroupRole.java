package com.project.users.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "GROUP_ROLE")
public class GroupRole {

    @Id
    @Column(name = "ID", columnDefinition = "uuid", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "GROUP_CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "GROUP_EN_NAME")
    private String nameEn;

    @Column(name = "GROUP_AR_NAME")
    private String nameAr;

}
