package com.financialtargets.users.application.dto.security;

import lombok.Data;

import java.util.Date;

@Data
public class TokenDTO {

    private String username;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accessToken;
    private String refreshToken;

    public TokenDTO() {}
}
