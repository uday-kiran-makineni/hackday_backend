package com.example.demo.repository;


import com.example.demo.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepository extends JpaRepository<Hackathon, Long> {
}
