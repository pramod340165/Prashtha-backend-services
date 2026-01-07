package com.pfpl.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfpl.login.entity.UserCredential;

public interface UserCredentialRepository  extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByName(String username);
}
