package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contests")
@Data
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false)
    private String date;

    private String time;

    private String duration;
}
