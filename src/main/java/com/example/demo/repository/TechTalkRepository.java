package com.example.demo.repository;


import com.example.demo.model.Hackathon;
import com.example.demo.model.TechTalk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechTalkRepository extends JpaRepository<TechTalk, Long> {
}