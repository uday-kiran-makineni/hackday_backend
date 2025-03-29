package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pesticides")
public class Pesticides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long farmerId;
    private String cropName;
    private String acres;
    private String diseaseName;
    private String pesticideName;
    private String pesticideStatus;
    private String pesticideQuantity;
}
