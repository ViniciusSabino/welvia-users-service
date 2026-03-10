package com.financialtargets.users.application.service.impl;

import com.financialtargets.users.application.service.UsersService;
import com.financialtargets.users.infrastructure.entity.UsersEntity;
import com.financialtargets.users.infrastructure.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServiceImpl implements UserDetailsService, UsersService {
    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity entity = this.repository.findByUsername(username);

        if(Objects.isNull(entity)) {
            throw new UsernameNotFoundException("Username "+ username +" not found");
        }

        return entity;
    }
}
