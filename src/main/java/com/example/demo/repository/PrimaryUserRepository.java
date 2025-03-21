package com.example.demo.repository;

import com.example.demo.model.PrimaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, Long> {
    Optional<PrimaryUser> findByUsername(String username);
    Optional<PrimaryUser> findById(Long id);
    Optional<PrimaryUser> findByEmail(String email);
}

