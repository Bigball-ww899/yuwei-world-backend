package com.yuwei.service;

import com.yuwei.dto.PocketDto;
import com.yuwei.entity.Pocket;
import com.yuwei.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PocketService {

    @Autowired
    private PocketRepository repository;

    public void save(PocketDto dto) {
        Pocket pocket = new Pocket();

        pocket.setName(dto.getName());
        pocket.setCurrentAmount(dto.getCurrentAmount());
        pocket.setTargetAmount(dto.getTargetAmount());
        pocket.setIcon(dto.getIcon());
        pocket.setCreatedAt(LocalDateTime.now());
        pocket.setUpdatedAt(LocalDateTime.now());

        repository.save(pocket);
    }

    public List<PocketDto> findAll() {
        List<Pocket> pockets = repository.findAll();

        return pockets.stream().map(pocket -> {
            PocketDto dto = new PocketDto();

            dto.setName(pocket.getName());
            dto.setCurrentAmount(pocket.getCurrentAmount());
            dto.setTargetAmount(pocket.getTargetAmount());
            dto.setIcon(pocket.getIcon());

            if (pocket.getTargetAmount().compareTo(BigDecimal.ZERO) == 0) {
                dto.setProgress(0);
            } else {
                int progress = pocket.getCurrentAmount()
                        .multiply(new BigDecimal("100"))
                        .divide(pocket.getTargetAmount(), 0, RoundingMode.HALF_UP)
                        .intValue();

                dto.setProgress(Math.min(progress, 100));
            }

            return dto;
        }).toList();
    }
}