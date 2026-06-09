package com.yuwei.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LifePhotoDto {

    private Long id;

    private String title;

    private String description;

    private LocalDate photoDate;

    private String imageUrl;
}