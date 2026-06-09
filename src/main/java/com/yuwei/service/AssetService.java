package com.yuwei.service;

import com.yuwei.dto.AssetDto;
import com.yuwei.entity.Asset;
import com.yuwei.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssetService {

    @Autowired
    private AssetRepository repository;

    public AssetDto getAsset() {

        Asset asset = repository.findById(1L)
                .orElseGet(() -> {

                    Asset newAsset = new Asset();
                    newAsset.setAmount(java.math.BigDecimal.ZERO);
                    newAsset.setUpdatedAt(LocalDateTime.now());

                    return repository.save(newAsset);
                });

        AssetDto dto = new AssetDto();
        dto.setAmount(asset.getAmount());

        return dto;
    }

    public void updateAsset(AssetDto dto) {

        Asset asset = repository.findById(1L)
                .orElseGet(() -> {

                    Asset newAsset = new Asset();
                    newAsset.setUpdatedAt(LocalDateTime.now());

                    return repository.save(newAsset);
                });

        asset.setAmount(dto.getAmount());
        asset.setUpdatedAt(LocalDateTime.now());

        repository.save(asset);
    }
}