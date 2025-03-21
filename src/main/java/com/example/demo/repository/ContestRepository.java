package com.example.demo.repository;

import com.example.demo.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {
}
