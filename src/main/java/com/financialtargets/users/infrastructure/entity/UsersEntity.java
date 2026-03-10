package com.financialtargets.users.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UsersEntity implements UserDetails {
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<PermissionEntity> permissions;

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();

        for (PermissionEntity permission : permissions) {
            roles.add(permission.getDescription());
        }

        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @PrePersist
    @PreUpdate
    private void syncUsername() {
        this.username = this.email;
    }

    public UsersEntity () {}
}