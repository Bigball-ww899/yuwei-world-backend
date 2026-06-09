package com.yuwei.controller;

import com.yuwei.dto.LifePhotoDto;
import com.yuwei.service.LifePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/life-photos")
public class LifePhotoController {

    @Autowired
    private LifePhotoService service;

    @GetMapping
    public List<LifePhotoDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void save(@RequestBody LifePhotoDto dto) {
        service.save(dto);
    }
}