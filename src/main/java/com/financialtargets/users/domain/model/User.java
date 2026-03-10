package com.financialtargets.users.domain.model;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String name;

    private String email;

    private String username;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    public User() {}
}