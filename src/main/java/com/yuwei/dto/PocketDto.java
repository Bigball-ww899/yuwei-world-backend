package com.yuwei.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PocketDto {

    private String name;

    private BigDecimal currentAmount;

    private BigDecimal targetAmount;

    private String icon;

    private Integer progress;
}