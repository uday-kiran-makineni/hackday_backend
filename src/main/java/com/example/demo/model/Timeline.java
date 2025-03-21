package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Timeline {
    private String registrationStart;
    private String registrationEnd;
    private String shortlisting; // Optional
    private String resultAnnouncement;
}
