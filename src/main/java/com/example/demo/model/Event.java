package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private String date;

    private String time;

    private String fee;

    private String slots;

    private String imageUrl;

    private String targetAudience;

    private String description;

    private String organization;

    private String theme;
}
