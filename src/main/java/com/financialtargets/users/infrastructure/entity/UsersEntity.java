package com.financialtargets.users.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="user_name", unique = true)
    private String username;

    @Column(name="password", nullable = true)
    private String password;

    @Column(name="account_non_expired", nullable = false)
    private Boolean accountNonExpired;

    @Column(name="account_non_locked", nullable = false)
    private Boolean accountNonLocked;

    @Column(name="credentials_non_expired", nullable = false)
    private Boolean credentialsNonExpired;

    @Column(name="enabled", nullable = false)
    private Boolean enabled;
}
