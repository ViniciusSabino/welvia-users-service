package com.financialtargets.users.infrastructure.repository;

import com.financialtargets.users.infrastructure.entity.UsersEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUsername(@Param("userName") String userName);
}