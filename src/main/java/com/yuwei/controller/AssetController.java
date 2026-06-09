package com.yuwei.controller;

import com.yuwei.dto.AssetDto;
import com.yuwei.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private AssetService service;

    @GetMapping
    public AssetDto getAsset() {
        return service.getAsset();
    }

    @PutMapping
    public void updateAsset(@RequestBody AssetDto dto) {
        service.updateAsset(dto);
    }
}