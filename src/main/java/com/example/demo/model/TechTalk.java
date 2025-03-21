package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "techtalks")
@Data
public class TechTalk {
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

    private String duration;

    private String speaker;

    private String fee;

    private String registrationStart;

    private String registrationEnd;

    private String imageUrl;

    private String description;

    private String organization;

    private String topic;
}
