package com.yuwei.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "life_photo")
public class LifePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate photoDate;

    private String imageUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}