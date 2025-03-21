package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hackathons")
@Data
public class Hackathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organization;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String endDate;

    private String time;

    private String venue;

    private String prize;

    private String fee;

    private String imageUrl;

    @Lob
    private String description;

    @Column
    private String objectives; // Comma-separated values for objectives

    private String eligibility;

    @Column
    private String tags; // Comma-separated values for tags

    @Embedded
    private Timeline timeline;
}
