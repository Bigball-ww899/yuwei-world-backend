package com.yuwei.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pocket")
public class Pocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal currentAmount;

    private BigDecimal targetAmount;

    private String icon;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}