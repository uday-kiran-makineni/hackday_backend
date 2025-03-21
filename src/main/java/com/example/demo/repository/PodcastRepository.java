package com.example.demo.repository;


import com.example.demo.model.Podcasts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcasts, Long> {
}