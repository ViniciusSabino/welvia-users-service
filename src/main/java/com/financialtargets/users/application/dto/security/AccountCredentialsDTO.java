package com.financialtargets.users.application.dto.security;

import lombok.Data;

@Data
public class AccountCredentialsDTO {
    private String username;
    private String password;

    public AccountCredentialsDTO() {
    }
}
