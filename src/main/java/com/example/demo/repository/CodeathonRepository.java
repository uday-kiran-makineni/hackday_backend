package com.example.demo.repository;


import com.example.demo.model.Codeathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeathonRepository extends JpaRepository<Codeathon, Long> {
}
