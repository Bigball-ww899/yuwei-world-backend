package com.yuwei.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LifeEventDto {

    private String content;

    private LocalDate eventDate;

}